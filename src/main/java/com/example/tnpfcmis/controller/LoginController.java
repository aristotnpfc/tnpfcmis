package com.example.tnpfcmis.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.tnpfcmis.model.Users;
import com.example.tnpfcmis.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userid, @RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        try {
            Users user = userRepository.findByUsernameAndPassword(username, password);

            // If user is found, set session and redirect to home page
            if (user != null) {
            	session.setAttribute(userid, user.getUser_id());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("role", user.getRole());
                return "redirect:/home";
            }
        } catch (Exception e) {
            // Handle invalid login
            model.addAttribute("error", "Invalid username or password!");
        }

        // Return to login page with error message
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage(HttpSession session) {
        // Check if user is logged in
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        // Check user role and redirect accordingly
        String role = (String) session.getAttribute("role");
        if ("ADMIN".equals(role)) {
            return "adminHome";
        } else {
            return "userHome";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
