package com.example.share_portfolio.post;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
        Question findByCategory(String category);
        Question findByCategoryAndContent(String category, String content);
        List<Question> findBySubjectLike(String subject);
}
