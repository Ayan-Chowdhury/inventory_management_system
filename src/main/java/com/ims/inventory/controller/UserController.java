package com.ims.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ims.inventory.model.User;
import com.ims.inventory.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
   
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
        // Add user session handling logic here
        return "redirect:/";
    }
}
