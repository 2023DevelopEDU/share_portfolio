package com.example.share_portfolio;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.share_portfolio.user.SiteUser;
import com.example.share_portfolio.user.UserRepository;

@Controller
public class MainController {

    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value="/")
    public String root(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getName())) {
            String username = auth.getName();
            SiteUser user = userRepository.findByusername(username).orElse(null);
            model.addAttribute("user", user);
        }
        return "layout_main";
    }
}
