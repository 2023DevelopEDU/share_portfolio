package com.example.share_portfolio.search;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SearchRepository extends JpaRepository<Search, Long> {
    List<Search> findByTitleContaining(String query);
    List<Search> findByContentContaining(String query);
    List<Search> findByTagContaining(String query);
}

