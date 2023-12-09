package com.m1xs0n.pr.service;


import com.m1xs0n.pr.business.entities.Post;
import com.m1xs0n.pr.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        var sort = postRepository.findAll();
        return sort;
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> updatePost(Long id, Post updatedPost) {
        if (postRepository.existsById(id)) {
            updatedPost.setId(id);
            return Optional.of(postRepository.save(updatedPost));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}



