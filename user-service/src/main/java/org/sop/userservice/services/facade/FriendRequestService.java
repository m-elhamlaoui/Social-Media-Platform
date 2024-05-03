package org.sop.userservice.services.facade;

import org.sop.userservice.dtos.FriendRequestDto;
import org.sop.userservice.models.Friend;

public interface FriendRequestService {
    FriendRequestDto findBySenderAndReceiver(Long sender, Long receiver);

    FriendRequestDto sendRequest(Long sender, Long receiver);

    Friend acceptRequest(Long sender, Long receiver);

    void rejectRequest(Long sender, Long receiver);
}
