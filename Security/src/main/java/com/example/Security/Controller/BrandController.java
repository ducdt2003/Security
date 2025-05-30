package com.example.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brands")
public class BrandController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String listBrands() {
        return "brands/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showCreateForm() {
        return "brands/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String createBrand() {
        return "redirect:/brands";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showEditForm(@PathVariable Long id) {
        return "brands/edit";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String updateBrand(@PathVariable Long id) {
        return "redirect:/brands";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String deleteBrand(@PathVariable Long id) {
        return "redirect:/brands";
    }
}
