package com.example.share_portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping(value="/")
    public String root() {
        return "/layout_main.html";
    }
    
}
