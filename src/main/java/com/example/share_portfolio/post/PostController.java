package com.example.share_portfolio.post;

import java.util.Optional;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class PostController {

    @Autowired
    private PostService postService; // Assume you have a service to fetch post data

    @GetMapping(value="post/{id}")
    public String Posts(@PathVariable("id") Long id, Model model){
        Optional<Post> postOptional = postService.getPostById(id);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            Parser parser = Parser.builder().build();
            Node document = parser.parse(post.getContent());
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            String htmlContent = renderer.render(document);
            post.setContent(htmlContent);
            model.addAttribute("post", post);
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
