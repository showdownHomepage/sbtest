package com.god.bo.controller;

import com.god.bo.domain.Post;
import com.god.bo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postService.savePostData(post);
    }

    @GetMapping("/posts")
    public List<Post> postList() {
        List<Post> posts = postService.getPostData();
        System.out.println(posts);
        return posts;
    }

    @GetMapping("/post")
    public Optional<Post> postDetail(
            @RequestParam(value = "id")Long id
    ) {
        Optional<Post> post = postService.findById(id);
        return post;
    }

    @PutMapping("/post/{id}")
    public Post postUpdate(
            @RequestBody Post post,
            @PathVariable Long id
    ) {
        Post updatePost = postService.updatePost(post, id);
        return updatePost;
    }

    @DeleteMapping("/post/{id}")
    public void postDelete(
            @RequestBody Post body,
            @PathVariable Long id
    ) {
        int p = postService.deletePost(id, body.getCreate());
        if (p == 1) {
            System.out.println("삭제 완료");
        }
    }
}
