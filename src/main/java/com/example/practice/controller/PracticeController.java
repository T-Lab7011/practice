package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PracticeController {
    private int currentValue = 1;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("value", currentValue);
        return "hello";
    }

    @GetMapping("/post-message")
    public String postMessage(Model model) {
        model.addAttribute("value", currentValue);
        return "post_message";
    }

    @PostMapping("/confirm-message")
    @ResponseBody
    public String confirmMessage(@RequestParam String message) {
        int receivedValue;
        try {
            receivedValue = Integer.parseInt(message);
        } catch (NumberFormatException e) {
            return String.valueOf(currentValue);
        }

        if (receivedValue == currentValue) {
            currentValue++;
        }
        return String.valueOf(currentValue);
    }
}
