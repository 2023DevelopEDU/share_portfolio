package com.example.share_portfolio.portfolio_board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class WritingController {

    @Autowired
    private WritingService writingService;

    @GetMapping("/search")
    public List<Writing> searchWritings(@RequestParam String category, @RequestParam String query) {
        if ("제목".equals(category)) {
            return writingService.searchByTitle(query);
        } else if ("내용".equals(category)) {
            return writingService.searchByContent(query);
        } else if ("태그".equals(category)) {
            return writingService.searchByTag(query);
        }

        return new ArrayList<>(); // 기본값은 빈 리스트 반환
    }
}


