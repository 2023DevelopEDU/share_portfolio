package com.example.share_portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.share_portfolio.user.SiteUser; // User 클래스의 패키지를 맞게 수정해야 합니다.
import com.example.share_portfolio.user.UserRepository; // UserRepository 클래스의 패키지를 맞게 수정해야 합니다.


@Controller
public class MyPageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/mypage/{id}")
    public String myPage(@PathVariable Long id, Model model) {
        SiteUser user = userRepository.findById(id).orElse(null);
        if (user == null) {
            // 사용자 정보가 없을 경우 처리
        }
        model.addAttribute("user", user);
        return "mypage";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute SiteUser updatedUser) {
        SiteUser user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            userRepository.save(user);
        }
        return "redirect:/mypage/" + id;
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/login"; // 회원 탈퇴 후 로그인 페이지로 리다이렉트
    }
}
