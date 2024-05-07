package org.sop.postservice.dtos;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PostDto {
   private Long id;
    private String text;
    private String image;
    private Date date;
    private Long userId;
    private Long likeId;

}