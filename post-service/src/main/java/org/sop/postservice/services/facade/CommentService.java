package org.sop.postservice.services.facade;

import org.sop.postservice.models.*;
import org.sop.postservice.response.CommentResponse;

import java.util.List;

public interface CommentService {
    Comment getCommentById(Long commentId);
    Comment updateComment(Long commentId, String text);
    void deleteComment(Long commentId);
    List<CommentResponse> getPostCommentsPaginate(Post postId, Integer page, Integer size);
    Comment createNewComment(String text, Long postId, Long userId);

}