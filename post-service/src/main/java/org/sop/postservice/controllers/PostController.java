package org.sop.postservice.controllers;

import org.modelmapper.ModelMapper;
import org.sop.postservice.dtos.PostDto;
import org.sop.postservice.models.Post;
import org.sop.postservice.services.facade.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final ModelMapper modelMapper;

    
    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        Post post = postService.findPostById(id);
        if (post != null) {
            PostDto postDto = modelMapper.map(post, PostDto.class);
            return ResponseEntity.ok(postDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        Post createdPost = postService.createPost(post);
        PostDto createdPostDto = modelMapper.map(createdPost, PostDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPostDto);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts.stream().map(post -> modelMapper.map(post, PostDto.class)).toList());
    }

}