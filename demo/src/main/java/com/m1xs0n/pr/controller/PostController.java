package com.m1xs0n.pr.controller;


import com.m1xs0n.pr.business.entities.Post;
import com.m1xs0n.pr.business.entities.User;
import com.m1xs0n.pr.service.PostService;
import com.m1xs0n.pr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/posts")
    public String listPosts(Model model) {
       List<Post> posts = postService.getAllPosts();
        model.addAttribute("post", posts);
        return "post/list";


    }
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post/view";
        } else {

            return "error";
        }
    }
        @GetMapping("/posts/add")
    public String showAddPostForm(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("post", new Post());
        return "post/add";
    }
    @PostMapping("/posts/add")
    public String addPost(@ModelAttribute Post post) {
        postService.createPost(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/edit/{id}")
    public String showUpdatePostForm(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.getPostById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post/edit";
        } else {
            return "error";
        }
    }
    @PostMapping("/posts/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post updatedPost) {
        Optional<Post> existingPost = postService.updatePost(id, updatedPost);
        if (existingPost.isPresent()) {
            return "redirect:/posts";
        } else {
            return "error";
        }
    }
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}

