package org.sop.chatservice.services.facade;

import org.sop.chatservice.models.Message;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface MessageService {
     List<Message> findChatMessages(Long userId1, Long userId2);
     void deleteBySenderIdAndReceiverIdAndSentAt(Long senderId, Long receiverId, LocalDate sentAt);
     void deleteChatMessages(Long userId1,Long userId2);
     Message save(Message message);
}
