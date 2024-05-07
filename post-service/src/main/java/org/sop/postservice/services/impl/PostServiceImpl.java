package org.sop.postservice.services.impl;

import org.sop.postservice.models.Post;
import org.sop.postservice.services.facade.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PostServiceImpl implements PostService {

    private final Map<Long, Post> postMap = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    @Override
    public Post findPostById(Long id) {
        return postMap.get(id);
    }

    @Override
    public Post createPost(Post post) {
        Long postId = getNextId();
        post.setId(postId);
        postMap.put(postId, post);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    private Long getNextId() {
        return nextId.getAndIncrement();
    }
}
