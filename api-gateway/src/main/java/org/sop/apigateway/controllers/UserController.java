package org.sop.apigateway.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
   @Autowired
   private UserService userService;
//
//    public UserDto findById(Long id) {
//        return us
//    }
//
//    public UserDto findByUsername(String username) {
//
//    }
//
//    public UserDto findByEmail(String email) {
//
//    }
//
//    public List<FriendDto> findFriends(Long id) {
//
//    }
//
//    public UserDto update(UserDto userDto) {
//
//    }
//
//    public boolean addFriend(Long id1, Long id2) {
//
//    }
//
//    public boolean removeFriend(Long id1, Long id2) {
//
//    }
}
