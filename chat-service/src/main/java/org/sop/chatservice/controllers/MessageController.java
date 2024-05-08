package org.sop.chatservice.controllers;

import org.modelmapper.ModelMapper;
import org.sop.chatservice.dtos.MessageDto;
import org.sop.chatservice.models.Message;
import org.sop.chatservice.services.facade.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public List<MessageDto> findChatMessages(Long userId1, Long userId2){
        List<Message> messages = messageService.findChatMessages(userId1,userId2);
        List<MessageDto> messageDtos = new ArrayList<>();
        for (Message message : messages) {
            MessageDto messageDto = modelMapper.map(message,MessageDto.class);
            messageDtos.add(messageDto);
        }
        return messageDtos;
    }
    public void deleteBySenderIdAndReceiverIdAndSentAt(Long senderId, Long receiverId, LocalDate sentAt){
        messageService.deleteBySenderIdAndReceiverIdAndSentAt(senderId,receiverId,sentAt);
    }
    public void deleteChatMessages(Long userId1,Long userId2){
        messageService.deleteChatMessages(userId1,userId2);
    }

    @MessageMapping("message")
    public void processMessage(@Payload MessageDto messageDto) {
        Message message = modelMapper.map(messageDto,Message.class);
        message = messageService.save(message);
        messageDto = modelMapper.map(message,MessageDto.class);
        messagingTemplate.convertAndSend("/topic/" + messageDto.getReceiverId(),  messageDto);
    }

}
