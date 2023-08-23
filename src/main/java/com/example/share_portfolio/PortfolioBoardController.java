package com.example.share_portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class PortfolioBoardController {

    @GetMapping
    public String portfolio(){
        return "portfolio_board";
    }
}