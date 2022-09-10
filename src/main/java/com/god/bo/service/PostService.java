package com.god.bo.service;

import com.god.bo.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post savePostData(Post post);
    List<Post> getPostData();
    Optional<Post> findById(Long id);
    Post updatePost(Post post, Long id);
    int deletePost(Long id, String create);
}
