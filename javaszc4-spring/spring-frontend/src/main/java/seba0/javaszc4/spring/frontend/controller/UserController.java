package seba0.javaszc4.spring.frontend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import seba0.javaszc4.spring.frontend.dao.User;

import java.util.Objects;


@Controller
@RequestMapping("/user")
class UserController {


    private RestTemplate templatenet = new RestTemplate();

    @GetMapping
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("register/user/form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(@ModelAttribute User user) {
        System.out.println(user);
        if (!Objects.equals(user.getPassword(), user.getPasswordConfirm())) {
            ModelAndView modelAndView = new ModelAndView("register/user/error");
            modelAndView.addObject("title", "Unable to add user");
            modelAndView.addObject("message", "Wrong password confirmation");
            return modelAndView;
        }
        ResponseEntity<Void> entity = templatenet.postForEntity("http://127.0.0.1:9090/customer", user, Void.class);
        if(entity.getStatusCode() != HttpStatus.OK) {

        }
        ModelAndView modelAndView = new ModelAndView("register/user/");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
