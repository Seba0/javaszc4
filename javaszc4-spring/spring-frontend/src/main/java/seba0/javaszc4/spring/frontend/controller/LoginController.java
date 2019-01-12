package seba0.javaszc4.spring.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
class LoginController {

    @GetMapping
    public String login() {
        return "login";
    }
}
