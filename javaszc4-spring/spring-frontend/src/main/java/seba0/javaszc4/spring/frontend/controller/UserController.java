package seba0.javaszc4.spring.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import seba0.javaszc4.spring.frontend.config.URLConfig;
import seba0.javaszc4.spring.frontend.dto.UserForm;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/user")
class UserController {

    @Autowired
    private URLConfig urlConfig;

    private final RestTemplate template = new RestTemplate();

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public ModelAndView list() {
        ResponseEntity<List> entity = template.getForEntity(urlConfig.getCustomer(), List.class);
        if (entity.getStatusCode() != HttpStatus.OK) {
            return error("Error", "Unable to get user list");
        }
        ModelAndView modelAndView = new ModelAndView("user/list");
        modelAndView.addObject("users", entity.getBody());
        return modelAndView;
    }

    @GetMapping("register")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("user/register");
        modelAndView.addObject("user", new UserForm());
        return modelAndView;
    }

    private ModelAndView error(String title, String message) {
        ModelAndView modelAndView = new ModelAndView("user/error");
        modelAndView.addObject("title", title);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(@Valid @ModelAttribute UserForm userForm) {
        if (!Objects.equals(userForm.getPassword(), userForm.getPasswordConfirm())) {
            return error("Unable to add user", "Wrong password confirmation");
        }
        try {
            userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
            ResponseEntity<String> entity = template.postForEntity(urlConfig.getCustomer(), userForm, String.class);
            if (entity.getStatusCode() != HttpStatus.OK) {
                return error("Unable to add user", entity.getBody());
            }
        } catch (RestClientResponseException e) {
            return error("Unable to add user", e.getResponseBodyAsString());
        }
        return list();
    }

    @DeleteMapping
    public ModelAndView delete(@RequestParam String id) {
        try {
            template.delete(urlConfig.getCustomer() + "/{id}", id);
        } catch (RestClientResponseException e) {
            return error("Unable to delete user", e.getResponseBodyAsString());
        }
        return list();
    }
}
