package org.sop.apigateway.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.sop.apigateway.security.models.User;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;
    private String phoneNumber;
    private String bio;
    private String image;
    private boolean enabled;

    public User toUser(User user) {
        user.setUsername(this.getUsername());
        user.setEmail(this.getEmail());
        user.setFirstname(this.getFirstname());
        user.setLastname(this.getLastname());
        user.setBirthdate(this.getBirthdate());
        user.setPhoneNumber(this.getPhoneNumber());
        user.setBio(this.getBio());
        user.setImage(this.getImage());
        user.setEnabled(this.enabled);
        return user;
    }
}
