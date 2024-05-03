package org.sop.userservice.repositories;

import org.sop.userservice.models.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    FriendRequest findBySenderAndReceiver(Long sender, Long receiver);

    List<FriendRequest> findBySender(Long id);

    List<FriendRequest> findByReceiver(Long id);

    void deleteBySenderAndReceiver(Long sender, Long receiver);

}
