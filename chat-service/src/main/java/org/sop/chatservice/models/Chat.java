package org.sop.chatservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chat {
    private Long id;
    private Long sender;
    private Long receiver;
    private String message;
}
