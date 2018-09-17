package seba0.javaszc4.hotel.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WWWController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView clientWeb() {
        ModelAndView model = new ModelAndView();
        model.setViewName("clientWeb");

        return model;
    }

}
