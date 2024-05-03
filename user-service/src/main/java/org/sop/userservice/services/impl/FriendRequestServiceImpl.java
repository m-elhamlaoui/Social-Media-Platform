package org.sop.userservice.services.impl;

import org.modelmapper.ModelMapper;
import org.sop.userservice.dtos.FriendRequestDto;
import org.sop.userservice.feignclients.ApiGatewayUserClient;
import org.sop.userservice.models.Friend;
import org.sop.userservice.models.FriendRequest;
import org.sop.userservice.models.User;
import org.sop.userservice.repositories.FriendRequestRepository;
import org.sop.userservice.services.facade.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {
    @Autowired
    private FriendRequestRepository friendRequestRepository;
    @Autowired
    private ApiGatewayUserClient apiGatewayUserClient;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FriendRequestDto findBySenderAndReceiver(Long sender, Long receiver) {
        FriendRequest friendRequest = friendRequestRepository.findBySenderAndReceiver(sender, receiver);
        return modelMapper.map(friendRequest, FriendRequestDto.class);
    }

    @Override
    public FriendRequestDto sendRequest(Long sender, Long receiver) {
        User user = apiGatewayUserClient.findById(receiver);
        if (user == null) return null;
        FriendRequest friendRequest = new FriendRequest(sender, receiver);
        friendRequest = friendRequestRepository.save(friendRequest);
        return modelMapper.map(friendRequest, FriendRequestDto.class);
    }

    @Override
    @Transactional
    public Friend acceptRequest(Long sender, Long receiver) {
        FriendRequest friendRequest = friendRequestRepository.findBySenderAndReceiver(sender, receiver);
        User user = apiGatewayUserClient.findById(sender);
        if (friendRequest == null || user == null) return null;
        friendRequestRepository.deleteBySenderAndReceiver(sender, receiver);
        apiGatewayUserClient.addFriend(sender, receiver);
        return modelMapper.map(user, Friend.class);
    }

    @Override
    @Transactional
    public void rejectRequest(Long sender, Long receiver) {
        friendRequestRepository.deleteBySenderAndReceiver(sender, receiver);
    }
}
