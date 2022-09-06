package com.god.bo.service;

import com.god.bo.domain.Post;

import java.util.Map;

public interface PostService {
    Map<String, Object> savePostData();
    Post getPostData();
}
