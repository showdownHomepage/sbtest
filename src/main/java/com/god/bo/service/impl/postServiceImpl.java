package com.god.bo.service.impl;

import com.god.bo.domain.Post;
import com.god.bo.service.PostService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class postServiceImpl implements PostService {

    private static Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L; // key 값을 생성

    @Override
    public Post savePostData(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post;
    }

    /* 전체 포스트 조회 */
    @Override
    public List<Post> getPostData() {
        return new ArrayList<>(store.values());
    }

    /* 특정 포스트 찾기 */
    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /* 포스트 수정 */
    // 제목, 내용, 카테고리만 수정 가능
    @Override
    public Post updatePost(Post post, Long id) {
        Post updatePost = store.get(id);
        if (updatePost == null) {
            System.out.println("해당 포스트가 존재하지 않습니다.");
            return null;
        }
        updatePost.setTitle(post.getTitle());
        updatePost.setContents(post.getContents());
        updatePost.setCategories(post.getCategories());
        return updatePost;
    }

    /* 포스트 삭제 */
    @Override
    public int deletePost(Long id, String create) {
        Post nowPost = store.get(id);
        System.out.println(nowPost.getCreate());
        System.out.println(create);
        if (nowPost == null) {
            System.out.println("해당 포스트가 존재하지 않습니다.");
            return -1;
        } else if (!nowPost.getCreate().equals(create)) {
            System.out.println("글쓴이와 일치하지 않습니다.");
            return -2;
        }
        store.remove(id);
        return 1;
    }

    public void clearStore() {
        store.clear();
    }
}
