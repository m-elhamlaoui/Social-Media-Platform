package org.sop.postservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LikePost {
    
    private Long id;
    private Long UserId;
    private Long postId;
}
