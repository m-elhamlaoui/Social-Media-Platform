package org.sop.postservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String text;
    private LocalDate createdAt;
    private Long userId;
    private Long postId;

}
