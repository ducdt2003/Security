package com.example.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SALE')")
    public String showDashboard() {
        return "dashboard";
    }
}
