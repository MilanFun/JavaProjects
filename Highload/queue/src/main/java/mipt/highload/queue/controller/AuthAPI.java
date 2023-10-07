package mipt.highload.queue.controller;

import mipt.highload.queue.entity.Token;
import mipt.highload.queue.entity.User;
import mipt.highload.queue.service.TokenGenerator;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthAPI {
    private List<User> list = new ArrayList<>();

    @Autowired
    AmqpTemplate template;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String create(@ModelAttribute("user") User user) {
        user.setToken(new Token(TokenGenerator.generateNewToken(), LocalDateTime.now().plusMinutes(5)));
        this.list.add(user);
        template.convertAndSend("queue4", user.getToken().getToken() + " " + user.getEmail());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("token", new Token());
        return "login";
    }

    @PostMapping("/login")
    public String auth(@ModelAttribute("token") Token token) {
        LocalDateTime now = LocalDateTime.now();
        for (User user : this.list) {
            if (user.getToken().getToken().equals(token.getToken())) {
                boolean isExpire = now.isAfter(user.getToken().getExpire());
                if (!isExpire) {
                    return "redirect:/success?token=" + token.getToken();
                } else {
                    return "redirect:/register";
                }
            }
        }
        return "redirect:/login";
    }

    @GetMapping("success")
    public String success(@RequestParam String token) {
        for (User user : this.list) {
            if (user.getToken().getToken().equals(token)) {
                boolean isExpire = LocalDateTime.now().isAfter(user.getToken().getExpire());
                if (isExpire) {
                    return "redirect:/register";
                }
            }
        }
        return "auth";
    }
}
