package io.udevs.apptaskmedical.service.impl;

import io.udevs.apptaskmedical.dto.request.UserDto;
import io.udevs.apptaskmedical.entity.Patient;
import io.udevs.apptaskmedical.entity.Staff;
import io.udevs.apptaskmedical.entity.User;
import io.udevs.apptaskmedical.enums.Role;
import io.udevs.apptaskmedical.repository.UserRepository;
import io.udevs.apptaskmedical.service.PatientService;
import io.udevs.apptaskmedical.service.StaffService;
import io.udevs.apptaskmedical.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final StaffService staffService;
    private final PatientService patientService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, StaffService service, PatientService patientService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.staffService = service;
        this.patientService = patientService;
    }

    @Override
    public User create(UserDto userDto) {
        User user = new User(null, userDto.getUserName(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getEmail(), userDto.getRole());
        User newUser = userRepository.save(user);
        if (userDto.getRole().equals(Role.ADMIN)){
            Staff staff = staffService.findById(userDto.getStaffOrPatientId());
            staff.setUser(newUser);
            staffService.create(staff);
        }else if (userDto.getRole().equals(Role.PATIENT)){
            Patient patient = patientService.findById(userDto.getStaffOrPatientId());
            patient.setUser(newUser);
            patientService.create(patient);
        }
        return newUser;
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
