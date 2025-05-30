package com.example.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String listUsers() {
        return "users/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm() {
        return "users/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String createUser() {
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable Long id) {
        return "users/edit";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateUser(@PathVariable Long id) {
        return "redirect:/users";
    }
}