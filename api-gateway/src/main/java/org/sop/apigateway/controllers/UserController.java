package org.sop.apigateway.controllers;

import org.sop.apigateway.dtos.FriendDto;
import org.sop.apigateway.dtos.UserDto;
import org.sop.apigateway.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserDto findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/friends/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<FriendDto> findFriends(@PathVariable Long id) {
        return userService.findFriends(id);
    }

    @DeleteMapping("/id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @GetMapping("/add-friend/{id1}/{id2}")
    @PreAuthorize("hasRole('USER')")
    public boolean addFriend(@PathVariable Long id1, @PathVariable Long id2) {
        return userService.addFriend(id1, id2);
    }

    @GetMapping("/remove-friend/{id1}/{id2}")
    @PreAuthorize("hasRole('USER')")
    public boolean removeFriend(@PathVariable Long id1, @PathVariable Long id2) {
        return userService.removeFriend(id1, id2);
    }
}
