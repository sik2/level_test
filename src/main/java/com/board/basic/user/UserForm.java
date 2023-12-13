package com.board.basic.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserForm {
    private String email;
    private String nickname;
    private String password;
    private String password2;
}
