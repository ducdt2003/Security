package com.example.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String listOrders() {
        return "orders/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showCreateForm() {
        return "orders/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String createOrder() {
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showEditForm(@PathVariable Long id) {
        return "orders/edit";
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String updateOrder(@PathVariable Long id) {
        return "redirect:/orders";
    }
}
