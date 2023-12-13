package com.board.basic.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(String email, String nickname, String password) {

        SiteUser siteUser = new SiteUser();
        siteUser.setEmail(email);
        siteUser.setNickname(nickname);

        siteUser.setPassword(passwordEncoder.encode(password));

        this.userRepository.save(siteUser);
    }

    public Optional<SiteUser> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
