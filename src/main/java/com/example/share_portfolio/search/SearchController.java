package com.example.share_portfolio.search;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService writingService;

    @GetMapping("/search")
    public List<Search> searchWritings(@RequestParam(required = false) String category, @RequestParam(required = false) String query) {
        if (category == null || query == null || category.isEmpty() || query.isEmpty()) {
            return writingService.getAllWritings();
        }
        if ("제목".equals(category)) {
            return writingService.searchByTitle(query);
        } else if ("내용".equals(category)) {
            return writingService.searchByContent(query);
        } else if ("태그".equals(category)) {
            return writingService.searchByTag(query);
        }

        return new ArrayList<>(); // Return empty list as default
    }
}
