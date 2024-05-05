package org.sop.chatservice.repositories;

import org.sop.chatservice.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findBySenderAndReceiver(Long sender, Long receiver);

    void deleteBySenderAndReceiver(Long sender, Long receiver);
}