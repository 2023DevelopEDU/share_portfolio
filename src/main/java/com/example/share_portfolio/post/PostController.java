package com.example.share_portfolio.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {
    
    @Autowired
    private PostService postService; // Assume you have a service to fetch post data

    @GetMapping(value="/{id}")
    public String Posts(@PathVariable("id") Long id, Model model){
        Optional<Post> postOptional = postService.getPostById(id);
        if (postOptional.isPresent()) {
            model.addAttribute("post", postOptional.get());
            return "post";
        } else {
            return "404";
        }
    }
}
