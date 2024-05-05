package org.sop.postservice.repository;

import org.sop.postservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findByEnsiastEmailOrderByCreatedAtDesc(String email);
}