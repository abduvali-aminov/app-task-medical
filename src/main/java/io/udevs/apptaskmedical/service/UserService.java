package io.udevs.apptaskmedical.service;

import io.udevs.apptaskmedical.dto.request.UserDto;
import io.udevs.apptaskmedical.entity.User;

public interface UserService {
    User create(UserDto userDto);
    boolean checkUsername(String userName);
    boolean validatePassword(String password);
}
