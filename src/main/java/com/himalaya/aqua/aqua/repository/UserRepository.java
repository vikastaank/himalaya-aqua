package com.himalaya.aqua.aqua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himalaya.aqua.aqua.core.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
