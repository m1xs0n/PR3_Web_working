package com.m1xs0n.pr.repository;


import com.m1xs0n.pr.business.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
