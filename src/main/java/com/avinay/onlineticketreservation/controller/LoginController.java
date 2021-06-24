package com.avinay.onlineticketreservation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.avinay.onlineticketreservation.model.entity.User;
import com.avinay.onlineticketreservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        model.addAttribute("target", request.getHeader("Referer"));
        return "login";
    }

    @GetMapping(value = "/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult.rejectValue(
                    "username",
                    "error.user",
                    "There is already a user registered with same username"
            );
        }

        if (!bindingResult.hasErrors()) {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
        }
        modelAndView.setViewName("registration");
        return modelAndView;
    }
}
