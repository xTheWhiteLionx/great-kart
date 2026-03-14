package com.greatlearning.great_kart.controller;

import com.greatlearning.great_kart.entity.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String welcome() {
        return "Hello World!";
    }
}
