package com.redis.cache.repository;

import java.util.Map;

import com.redis.cache.models.User;

public interface UserRepository {
    void save(User user);
    Map<String,User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);
}