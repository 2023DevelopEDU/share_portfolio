package com.example.share_portfolio.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository writingRepository;

    public List<Search> searchByTitle(String query) {
        // 제목으로 검색하여 결과 반환
        return writingRepository.findByTitleContaining(query);
    }

    public List<Search> searchByContent(String query) {
        // 내용으로 검색하여 결과 반환
        return writingRepository.findByContentContaining(query);
    }

    public List<Search> searchByTag(String query) {
        // 태그로 검색하여 결과 반환
        return writingRepository.findByTagContaining(query);
    }
    public List<Search> getAllWritings() {
        // Implement the method to fetch all writings from the database
        return writingRepository.findAll();
    }
}