package com.example.share_portfolio.portfolio_board;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WritingRepository extends JpaRepository<Writing, Long> {
    List<Writing> findByTitleContaining(String query);
    List<Writing> findByContentContaining(String query);
    List<Writing> findByTagContaining(String query);
}

