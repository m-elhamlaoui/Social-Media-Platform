package org.sop.userservice.controllers;

import org.sop.userservice.dtos.FriendRequestDto;
import org.sop.userservice.feignclients.ApiGatewayUserClient;
import org.sop.userservice.models.Friend;
import org.sop.userservice.models.User;
import org.sop.userservice.services.facade.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/friend-request")
public class FriendRequestController {
    @Autowired
    private FriendRequestService friendRequestService;
    @Autowired
    private ApiGatewayUserClient apiGatewayUserClient;

    @GetMapping("/test/{id}")
    public User findshit(@PathVariable Long id) {
        return apiGatewayUserClient.findById(id);
    }

    @GetMapping("/{sender}/{receiver}")
    public FriendRequestDto findBySenderAndReceiver(@PathVariable Long sender, @PathVariable Long receiver) {
        return friendRequestService.findBySenderAndReceiver(sender, receiver);
    }


    @PostMapping("/{sender}/{receiver}")
    public FriendRequestDto sendRequest(@PathVariable Long sender, @PathVariable Long receiver) {
        return friendRequestService.sendRequest(sender, receiver);
    }

    @DeleteMapping("/accept/{sender}/{receiver}")
    public Friend acceptRequest(@PathVariable Long sender, @PathVariable Long receiver) {
        return friendRequestService.acceptRequest(sender, receiver);
    }

    @DeleteMapping("/reject/{sender}/{receiver}")
    public void rejectRequest(@PathVariable Long sender, @PathVariable Long receiver) {
        friendRequestService.rejectRequest(sender, receiver);
    }
}
