package com.example.share_portfolio.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

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
