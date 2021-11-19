package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.entity.User;
import io.udevs.apptaskmedical.repository.UserRepository;
import io.udevs.apptaskmedical.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public boolean checkUsername(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public boolean validatePassword(String password){
        return password.length() >= 8;
    }
}
