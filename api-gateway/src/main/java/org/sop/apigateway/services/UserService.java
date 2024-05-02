package org.sop.apigateway.services;

import org.modelmapper.ModelMapper;
import org.sop.apigateway.dtos.FriendDto;
import org.sop.apigateway.dtos.UserDto;
import org.sop.apigateway.security.models.User;
import org.sop.apigateway.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) return null;
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto findByEmail(String email) {
        User user = userRepository.findByUsername(email).orElse(null);
        if (user == null) return null;
        return modelMapper.map(user, UserDto.class);
    }

    public List<FriendDto> findFriends(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null || user.getFriends() == null || user.getFriends().isEmpty()) return new ArrayList<>();
        List<FriendDto> friendDtos = new ArrayList<>();
        for (User friend : user.getFriends()) {
            FriendDto friendDto = modelMapper.map(friend, FriendDto.class);
            friendDtos.add(friendDto);
        }
        return friendDtos;
    }

    public UserDto update(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername()) || userRepository.existsByEmail(userDto.getEmail()))
            return null;
        User user = userRepository.findById(userDto.getId()).orElse(null);
        if (user == null) return null;
        user = userDto.toUser(user);
        user = userRepository.save(user);
        userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public boolean addFriend(Long id1, Long id2) {
        User user1 = userRepository.findById(id1).orElse(null);
        User user2 = userRepository.findById(id2).orElse(null);
        if (user1 == null || user2 == null) return false;
        if (user1.getFriends() == null) user1.setFriends(new ArrayList<>());
        if (user2.getFriends() == null) user2.setFriends(new ArrayList<>());
        user1.getFriends().add(user2);
        user2.getFriends().add(user1);
        userRepository.save(user1);
        userRepository.save(user2);
        return true;
    }

    public boolean removeFriend(Long id1, Long id2) {
        User user1 = userRepository.findById(id1).orElse(null);
        User user2 = userRepository.findById(id2).orElse(null);
        if (user1 == null || user2 == null) return false;
        user1.getFriends().remove(user2);
        user2.getFriends().remove(user1);
        userRepository.save(user1);
        userRepository.save(user2);
        return true;
    }

}
