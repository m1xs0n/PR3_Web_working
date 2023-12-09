package com.m1xs0n.pr.service;


import com.m1xs0n.pr.business.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long id);
    Post createPost(Post post);
    Optional<Post> updatePost(Long id, Post post);
    void deletePost(Long id);
}
