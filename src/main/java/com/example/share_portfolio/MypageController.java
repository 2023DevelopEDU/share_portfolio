package com.example.share_portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.share_portfolio.user.SiteUser;
import com.example.share_portfolio.user.UserRepository;

@RequestMapping("/mypage")
@Controller
public class MypageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String page(Model model) {
        // get the current user
        // this is just an example, you should get the currently logged-in user
        SiteUser user = userRepository.findById(1L).orElse(new SiteUser());
        model.addAttribute("user", user);
        return "my_page";
    }

    @PostMapping
    public String update(@ModelAttribute SiteUser user) {
        // update the user
        userRepository.save(user);
        return "redirect:/mypage";
    }
}
