package com.example.share_portfolio.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import com.example.share_portfolio.user.SiteUser;
import com.example.share_portfolio.user.UserService;


@RequestMapping
@Controller
public class PostController {
    
    @Autowired
    private PostService postService; // Assume you have a service to fetch post data
    
    private UserService userService;


    @GetMapping(value="post/{id}")
    public String Posts(@PathVariable("id") Long id, Model model){
        Optional<Post> postOptional = postService.getPostById(id);
        if (postOptional.isPresent()) {
            model.addAttribute("post", postOptional.get());
            return "post";
        } else {
            return "404";
        }
    }
    @PostMapping("/post/save")
    public String savePost(Post post){
        postService.savePost(post);
        return "redirect:/post/" + post.getId();
    }
}
