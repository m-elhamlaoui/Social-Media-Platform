package org.sop.postservice.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Post {
    
    private Long id;
    private String text;
    private String image;
    private Date date;
    private Long userId;
    private Long likeId;


}