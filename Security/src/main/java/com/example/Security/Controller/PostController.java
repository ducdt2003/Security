package com.example.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String listPosts() {
        return "posts/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String showCreateForm() {
        return "posts/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String createPost() {
        return "redirect:/posts";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String showEditForm(@PathVariable Long id) {
        return "posts/edit";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String updatePost(@PathVariable Long id) {
        return "redirect:/posts";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE', 'AUTHOR')")
    public String deletePost(@PathVariable Long id) {
        return "redirect:/posts";
    }
}
