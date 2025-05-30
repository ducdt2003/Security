package com.example.Security.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String viewProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("user", authentication.getPrincipal());
        } else {
            model.addAttribute("user", null);
        }
        return "profile/view";
    }

    @GetMapping("/edit")
    @PreAuthorize("hasRole('USER')")
    public String showEditForm(Model model) {
        // Lấy thông tin người dùng hiện tại từ SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("user", authentication.getPrincipal());
        } else {
            model.addAttribute("user", null);
        }
        return "profile/edit";
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('USER')")
    public String updateProfile(@RequestParam String username, @RequestParam String password) {
        // TODO: Cập nhật thông tin người dùng (ví dụ: lưu vào UserDetailsService)
        // Lưu ý: InMemoryUserDetailsManager không hỗ trợ cập nhật trực tiếp,
        // bạn cần triển khai logic lưu vào cơ sở dữ liệu hoặc cấu hình khác
        return "redirect:/profile";
    }
}