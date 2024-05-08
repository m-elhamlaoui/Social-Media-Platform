package org.sop.chatservice.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    private Long id;
    private String message;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate sentAt;
    private Long senderId;
    private Long receiverId;
}
