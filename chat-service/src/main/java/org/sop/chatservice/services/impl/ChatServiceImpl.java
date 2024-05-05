package org.sop.chatservice.services.impl;

import org.modelmapper.ModelMapper;
import org.sop.chatservice.dtos.ChatDto;
import org.sop.chatservice.models.Chat;
import org.sop.chatservice.repositories.ChatRepository;
import org.sop.chatservice.services.facade.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ChatDto findBySenderAndReceiver(Long sender, Long receiver) {
        Chat chat = chatRepository.findBySenderAndReceiver(sender, receiver);
        return convertToDto(chat);
    }

    @Override
    public ChatDto sendChat(Long sender, Long receiver, String message) {
        Chat chat = new Chat();
        chat.setSender(sender);
        chat.setReceiver(receiver);
        chat.setMessage(message);
        Chat savedChat = chatRepository.save(chat);
        return convertToDto(savedChat);
    }

    @Override
    public void deleteChat(Long sender, Long receiver) {
        chatRepository.deleteBySenderAndReceiver(sender, receiver);
    }

    private ChatDto convertToDto(Chat chat) {
        return modelMapper.map(chat, ChatDto.class);
    }
}
