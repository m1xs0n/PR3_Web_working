package com.m1xs0n.pr.repository;


import com.m1xs0n.pr.business.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
