package org.sop.chatservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatDto {
    private Long id;
    private Long sender;
    private Long receiver;
    private String message;
}
