package com.axle.springeshop.controllers;

import com.axle.springeshop.service.SessionObjectHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class MainController {

    private final SessionObjectHolder sessionObjectHolder;

    @Autowired
    public MainController(SessionObjectHolder sessionObjectHolder) {
        this.sessionObjectHolder = sessionObjectHolder;
    }

    @RequestMapping({"", "/"})
    public String index(Model model, HttpSession httpSession) {
        model.addAttribute("amountClicks", sessionObjectHolder.getAmountClicks());
        if (httpSession.getAttribute("myId") == null) {
            String uuid = UUID.randomUUID().toString();
            httpSession.setAttribute("myID", uuid);
            System.out.println("Generated UUID -> " + uuid);
        }
        model.addAttribute("uuid", httpSession.getAttribute("myID"));
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error") //что-бы пользователь попал на 404-page
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
