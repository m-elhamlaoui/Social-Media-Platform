package org.sop.chatservice.repositories;

import org.sop.chatservice.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findBySenderIdAndReceiverIdAndSentAt(Long senderId, Long receiverId, LocalDate sentAt);

    List<Message> findBySenderIdAndReceiverId(Long senderId,Long receiverId);

    int deleteBySenderIdAndReceiverIdAndSentAt(Long senderId, Long receiverId, LocalDate sentAt);

    int deleteBySenderIdAndReceiverId(Long senderId,Long receiverId);
}
