package org.sop.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendRequestDto {
    private Long id;
    private Long sender;
    private Long receiver;
}
