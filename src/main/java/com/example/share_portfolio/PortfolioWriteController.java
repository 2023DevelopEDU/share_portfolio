package com.example.share_portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/writing")
@Controller
public class PortfolioWriteController {
    @GetMapping
    public String write(){
        return "portfolio_write";
    }
}
