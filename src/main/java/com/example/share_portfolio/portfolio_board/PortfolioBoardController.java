package com.example.share_portfolio.portfolio_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.share_portfolio.search.Search;
import com.example.share_portfolio.search.SearchRepository;

import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;

@RequestMapping("/board")
@Controller
public class PortfolioBoardController {

    @Autowired
    private SearchRepository writingRepository;

    @GetMapping
    public String list(Model model) {
        List<Search> writings = writingRepository.findAll();
        if(writings.isEmpty()){
            System.out.println("isempty");
        }
        //db 연결 성공 시 데이터 출력
        for (Search writing : writings) {
            System.out.println("Writing ID: " + writing.getId());
            System.out.println("Writing Title: " + writing.getTitle());
            System.out.println("Writing Content: " + writing.getContent());
            System.out.println("Writing Tag: " + writing.getTag());
            System.out.println("Writing Tag: " + writing.getLike());
        }
    
        model.addAttribute("writings", writings != null ? writings : new ArrayList<>()); // 빈 리스트 설정
        return "portfolio_board";
    }
}

