package io.udevs.apptaskmedical.dto.request;

import io.udevs.apptaskmedical.enums.Role;
import lombok.Data;


@Data
public class UserDto {
    private String userName;
    private String password;
    private String email;
    private Role role;
    private Long staffOrPatientId;
}
