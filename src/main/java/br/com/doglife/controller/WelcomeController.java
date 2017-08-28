package br.com.doglife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome")
    public ModelAndView login(ModelMap model) {
        return new ModelAndView("welcome");
    }

}
