package org.sop.postservice.services.impl;

import org.sop.postservice.models.Comment;
import org.sop.postservice.models.Post;
import org.sop.postservice.repositories.CommentRepository;
import org.sop.postservice.response.CommentResponse;
import org.sop.postservice.services.facade.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

   @Override
@Transactional
public Comment createNewComment(String text, Long postId, Long userId) {
    LocalDate currentDate = LocalDate.now();
    if (postId == null) {
        return null;
    }
    Comment comment = Comment.builder()
                            .date(currentDate)
                            .text(text)
                            .postId(postId)
                            .userId(userId)
                            .build();
    return commentRepository.save(comment);
}


    @Override
    @Transactional
    public Comment updateComment(Long commentId, String text) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if (comment != null) {
            comment.setText(text);
            return commentRepository.save(comment);
        }
        return null;
    }


    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentResponse> getPostCommentsPaginate(Post postId, Integer page, Integer size) {
        return null;
    }
}

