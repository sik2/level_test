package com.board.basic.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout() {
        return "logout";
    }

    @GetMapping("/join")
    public String join () {
        return "join_form";
    }

    @PostMapping("/join")
    public String join (UserForm userForm, @RequestParam(value="email") String email, @RequestParam(value="nickname") String nickname, @RequestParam(value="password") String password, @RequestParam(value="password2") String password2) {
        userForm.setEmail(email);
        userForm.setNickname(nickname);
        userForm.setPassword(password);
        userForm.setPassword2(password2);

        if (!userForm.getPassword().equals(userForm.getPassword2())) {
            System.out.println("비밀번호 불일치");
            return "join_form";
        }

        this.userService.create(userForm.getEmail(), userForm.getNickname(), userForm.getPassword());

        return "join_form";
    }

}
