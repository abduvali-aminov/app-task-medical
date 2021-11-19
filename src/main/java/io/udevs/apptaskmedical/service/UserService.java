package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.entity.User;

public interface UserService {
    User create(User user);
    boolean checkUsername(String userName);
    boolean validatePassword(String password);
}
