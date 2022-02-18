package com.example.applicationname.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
public class IndexController {

    @GetMapping("/halebob")
    public String text(@RequestParam String text) {
        LocalDate date = LocalDate.now();
        String[] dateArray = date.toString().split("-");
        int q = Integer.parseInt(dateArray[2]);
        int m = Integer.parseInt(dateArray[1]);
        int j = Integer.parseInt(dateArray[0]) / 100;
        int k = Integer.parseInt(dateArray[0]) % 100;

        int h = (q + 13 * (m + 1)/5 + k + (k/4) + (j/4) - 2*j)%7;
        int d = ((h + 5)%7) + 1;
        switch(d) {
            case 0: return "No, it's wednesday";
            case 1: return "No, it's thursday";
            case 2: return "Yes!";
            case 3: return "No, it's saturday";
            case 4: return "No, it's sunday";
            case 5: return "No, it is monday";
            case 6: return "No, it's tuesday";
            default: return "what";
        }
    }

}
