package org.sop.chatservice.controllers;

import org.sop.chatservice.dtos.ChatDto;
import org.sop.chatservice.services.facade.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/{sender}/{receiver}")
    public ChatDto findBySenderAndReceiver(@PathVariable Long sender, @PathVariable Long receiver) {
        return chatService.findBySenderAndReceiver(sender, receiver);
    }

    @PostMapping("/{sender}/{receiver}")
    public ChatDto sendChat(@PathVariable Long sender, @PathVariable Long receiver, @RequestBody String message) {
        return chatService.sendChat(sender, receiver, message);
    }

    @DeleteMapping("/{sender}/{receiver}")
    public void deleteChat(@PathVariable Long sender, @PathVariable Long receiver) {
        chatService.deleteChat(sender, receiver);
    }
}
