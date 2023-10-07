package org.example.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
//  @GetMapping("/hello")
//  public String halloPage(HttpServletRequest request) {
//    String name = request.getParameter("name");
//    String surname = request.getParameter("surname");
//
//    System.out.println("Hello, " + name + " " + surname);
//
//    return "first/hello";
//  }

  @GetMapping("/hello")
  public String halloPage(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname, Model model) {
    model.addAttribute("message", "Hello," + name + " " + surname);
    return "first/hello";
  }

  @GetMapping("/goodbye")
  public String goodByePage() {
    return "first/goodbye";
  }

  @GetMapping("/calculate")
  public String calculate(@RequestParam(value = "a", required = false) Integer a,
                          @RequestParam(value = "b", required = false) Integer b,
                          @RequestParam(value = "action", required = false) String action,
                          Model model) {

    switch (action) {
      case "multiplication":
        model.addAttribute("result", "a * b = " + (a * b));
        break;
      case "addition":
        model.addAttribute("result", "a + b = " + (a + b));
        break;
      case "subtraction":
        model.addAttribute("result", "a - b = " + (a - b));
        break;
      case "division":
        try {
          double res = a / (double)b;
          model.addAttribute("result", "a / b = " + res);
        } catch (ArithmeticException e) {
          model.addAttribute("result", "Division by zero");
        }
      default:
        break;
    }

    return "/first/calculator";
  }
}
