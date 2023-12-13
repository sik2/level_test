package com.board.basic.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout() {
        return "logout";
    }
}
