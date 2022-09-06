package com.god.bo.service.impl;

import com.god.bo.domain.Post;
import com.god.bo.service.PostService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class postServiceImpl implements PostService {

    @Override
    public Map<String, Object> savePostData() {
        Map<String, Object> postData = new HashMap<>();

        postData.put("1", "content1");
        postData.put("2", "content2");
        postData.put("3", "content3");

        return postData;
    }

    @Override
    public Post getPostData() {
        return null;
    }
}
