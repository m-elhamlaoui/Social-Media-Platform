package org.sop.apigateway.services.facade;

import org.sop.apigateway.dtos.FriendDto;
import org.sop.apigateway.dtos.UserDto;

import java.util.List;

public interface UserService {
    public UserDto findById(Long id);

    public UserDto findByUsername(String username);

    public List<FriendDto> findFriends(Long id);

    public void deleteById(Long id);

    public UserDto update(UserDto userDto);

    public boolean addFriend(Long id1, Long id2);

    public boolean removeFriend(Long id1, Long id2);
}
