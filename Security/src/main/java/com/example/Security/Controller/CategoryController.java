package com.example.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String listCategories() {
        return "categories/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showCreateForm() {
        return "categories/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String createCategory() {
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showEditForm(@PathVariable Long id) {
        return "categories/edit";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String updateCategory(@PathVariable Long id) {
        return "redirect:/categories";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String deleteCategory(@PathVariable Long id) {
        return "redirect:/categories";
    }
}