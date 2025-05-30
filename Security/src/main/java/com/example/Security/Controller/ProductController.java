package com.example.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String listProducts() {
        return "products/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showCreateForm() {
        return "products/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String createProduct() {
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showEditForm(@PathVariable Long id) {
        return "products/edit";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String updateProduct(@PathVariable Long id) {
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String deleteProduct(@PathVariable Long id) {
        return "redirect:/products";
    }
}
