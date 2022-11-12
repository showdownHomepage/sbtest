package com.god.bo.repository;

import com.god.bo.domain.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryPostRepository implements PostRepository{

    private static Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Post save(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Post> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Post> findAll() {
        return null;
    }
}
