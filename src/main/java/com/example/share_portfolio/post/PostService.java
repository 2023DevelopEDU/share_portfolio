package com.example.share_portfolio.post;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.share_portfolio.user.SiteUser;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post create(String category, String content, SiteUser username) {
        Post q = new Post();
        q.setCategory(category);
        q.setContent(content);
        q.setAuthor(username);
        return this.postRepository.save(q);
    }

    // 모든 게시물 가져오기
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 특정 ID의 게시물 가져오기
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // 게시물 저장하고 저장된 게시물 반환
    public Post savePost(Post post){
        return postRepository.save(post);
    }
}
