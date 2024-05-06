package org.sop.postservice.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Comment {
    
     private Long id;
    private String text;
    private Long userId;
    private Long postId;
    private Date date;

}
