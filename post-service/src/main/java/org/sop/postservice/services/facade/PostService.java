package org.sop.postservice.services.facade;

import org.sop.postservice.models.Post;

import java.util.List;

public interface PostService {
    Post findPostById(Long id);
    Post createPost(Post post);
    List<Post> getAllPosts();
}