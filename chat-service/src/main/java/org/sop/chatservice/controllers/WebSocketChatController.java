package org.sop.chatservice.controllers;

import org.sop.chatservice.dtos.ChatDto;
import org.sop.chatservice.services.facade.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketChatController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatDto sendChat(ChatDto chatDto) {
        // Persist chat message
        chatService.sendChat(chatDto.getSender(), chatDto.getReceiver(), chatDto.getMessage());
        return chatDto;
    }
}
