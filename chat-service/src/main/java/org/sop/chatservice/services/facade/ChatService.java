package org.sop.chatservice.services.facade;

import org.sop.chatservice.dtos.ChatDto;

public interface ChatService {
    ChatDto findBySenderAndReceiver(Long sender, Long receiver);

    ChatDto sendChat(Long sender, Long receiver, String message);

    void deleteChat(Long sender, Long receiver);
    
    void processWebSocketMessage(ChatDto chatDto);
}