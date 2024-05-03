package org.sop.userservice.services.facade;

import org.sop.userservice.models.FriendRequest;

public interface FriendRequestService {
    FriendRequest sendRequest(Long userSender, Long userReceiver);

    Friend acceptRequest(Long userSender,Long userReceiver);
}
