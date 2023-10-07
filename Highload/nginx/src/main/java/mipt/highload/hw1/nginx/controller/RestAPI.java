package mipt.highload.hw1.nginx.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@RestController
@RequestMapping("/api")
public class RestAPI {

    @RequestMapping(value = "/date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDate() {
        JSONObject date = new JSONObject();
        LocalDate today = LocalDate.now();
        date.put("month", today.getMonthValue());
        date.put("day", today.getDayOfMonth());
        date.put("year", today.getYear());

        JSONArray response = new JSONArray();
        for (int i = 0; i < 10000; i++) {
            response.put(date);
        }

        return ResponseEntity.ok(response.toString());
    }

    @RequestMapping(value = "/person", method = { RequestMethod.GET, RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPerson(@RequestParam String name) {
        JSONObject person = new JSONObject();
        person.put("name", name);

        JSONArray response = new JSONArray();
        for (int i = 0; i < 10000; i++) {
            response.put(person);
        }
        return ResponseEntity.ok(response.toString());
    }
}
