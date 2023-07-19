package com.ogu.instagram.user.dto;

import com.ogu.instagram.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String nickname;

    public UserDto(User user) {
       this.id = user.getId();
       this.username = user.getUsername();
       this.nickname = user.getNickname();
    }
}
