package org.sop.chatservice.services.impl;

import org.sop.chatservice.models.Message;
import org.sop.chatservice.repositories.MessageRepository;
import org.sop.chatservice.services.facade.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findChatMessages(Long userId1,Long userId2){
        List<Message> messagesUserId1 = messageRepository.findBySenderIdAndReceiverId(userId1,userId2);
        List<Message> messagesUserId2 = messageRepository.findBySenderIdAndReceiverId(userId2,userId1);
        List<Message> messages = new ArrayList<>();
        messages.addAll(messagesUserId1);
        messages.addAll(messagesUserId2);
        messages.sort(Comparator.comparing(Message::getSentAt));
        return messages;
    }

    @Transactional
    public void deleteBySenderIdAndReceiverIdAndSentAt(Long senderId, Long receiverId, LocalDate sentAt){
        messageRepository.deleteBySenderIdAndReceiverIdAndSentAt(senderId,receiverId,sentAt);
    }

    @Transactional
    public void deleteChatMessages(Long userId1,Long userId2){
        messageRepository.deleteBySenderIdAndReceiverId(userId1,userId2);
        messageRepository.deleteBySenderIdAndReceiverId(userId2,userId1);
    }

    public Message save(Message message){
        Message foundMessage = messageRepository.findBySenderIdAndReceiverIdAndSentAt(message.getSenderId(),message.getReceiverId(),message.getSentAt());
        if(foundMessage != null) return foundMessage;
        return messageRepository.save(message);
    }

}
