package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    //AUTHENTIFICATION DE L'UTILISATEUR POUR ACCEDER A L'APPLICATION
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //DECONNEXION DE L'UTILISATEUR A L'APPLICATION
    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }
        
    //AUTORISATION D'ACCEDER A LA PAGE HOME
    @RequestMapping("/home")
    public String goHome() {
        return "home";
    }

}