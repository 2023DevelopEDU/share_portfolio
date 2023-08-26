package com.example.share_portfolio.portfolio_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WritingService {

    @Autowired
    private WritingRepository writingRepository;

    public List<Writing> searchByTitle(String query) {
        // 제목으로 검색하여 결과 반환
        return writingRepository.findByTitleContaining(query);
    }

    public List<Writing> searchByContent(String query) {
        // 내용으로 검색하여 결과 반환
        return writingRepository.findByContentContaining(query);
    }

    public List<Writing> searchByTag(String query) {
        // 태그로 검색하여 결과 반환
        return writingRepository.findByTagContaining(query);
    }
}