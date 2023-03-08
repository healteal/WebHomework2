package com.example.jsp_practice.controllers;

import com.example.jsp_practice.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class mainController {
    private Long guess = 50L;
    private Long maxValue = 100L;

    private User user;

    @GetMapping("/")
    public String mainPage(Model model,
                           @RequestParam(value = "number_to_guess", required = false) Long number,
                           @RequestParam(value = "check", required = false) String check,
                           @RequestParam(value = "first_number", required = false) Long firstNumber,
                           @RequestParam(value = "second_number", required = false) Long secondNumber,
                           @RequestParam(value = "third_number", required = false) Long thirdNumber,
                           @RequestParam(value = "math_action", required = false) String math_action
    ) {
        guessANumber(model, number, check);
        if (user != null) {
            model.addAttribute(user);
        }
        actionWithNumbers(model, firstNumber, secondNumber, thirdNumber, math_action);
        return "main-page";
    }

    private static void actionWithNumbers(Model model, Long firstNumber, Long secondNumber, Long thirdNumber, String math_action) {
        if (firstNumber != null) {
            switch (math_action) {
                case "max" -> {
                    if (firstNumber > Math.max(secondNumber, thirdNumber)) {
                        model.addAttribute("final_number", firstNumber);
                    } else {
                        model.addAttribute("final_number", Math.max(secondNumber, thirdNumber));
                    }
                }
                case "min" -> {
                    if (firstNumber < Math.min(secondNumber, thirdNumber)) {
                        model.addAttribute("final_number", firstNumber);
                    } else {
                        model.addAttribute("final_number", Math.min(secondNumber, thirdNumber));
                    }
                }
                case "avg" -> model.addAttribute("final_number", (firstNumber + secondNumber + thirdNumber) / 3);
            }
        }
    }

    @PostMapping("/")
    public String formPage(User user) {
        this.user = user;
        return "redirect:/";
    }

    private void guessANumber(Model model, Long number, String check) {
        if (number == null || (number >= 0 & number <= 100)) {
            model.addAttribute("number", number);
            model.addAttribute("guess", guess);
        }
        if (check != null) {
            switch (check) {
                case "Больше" -> {
                    guess += ((maxValue - guess) / 2);
                    model.addAttribute("guess", guess);
                }
                case "Меньше" -> {
                    maxValue = guess;
                    guess -= ((guess) / 2);
                    model.addAttribute("guess", guess);
                }
                case "Равно" -> {
                    if (Objects.equals(number, guess)) {
                        model.addAttribute("answer", "Верный ответ");
                    } else {
                        model.addAttribute("answer", "Неверный ответ");
                    }
                }
            }
        }
    }
}
