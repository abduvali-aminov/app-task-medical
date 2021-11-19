package io.udevs.apptaskmedical;

import io.udevs.apptaskmedical.entity.Role;
import io.udevs.apptaskmedical.entity.User;
import io.udevs.apptaskmedical.repository.RoleRepository;
import io.udevs.apptaskmedical.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AppTaskMedicalApplication {
    private final PasswordEncoder passwordEncoder;

    public AppTaskMedicalApplication(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppTaskMedicalApplication.class, args);
    }
    @Bean
    public CommandLineRunner demoRole(RoleRepository repository) {
        return (args) -> {
            repository.save(new Role("ADMIN"));
            repository.save(new Role("PATIENT"));
        };
    }

    @Bean
    public CommandLineRunner demoUser(UserRepository repository) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role("ADMIN"));

        Set<Role> roleSet2 = new HashSet<>();
        roleSet2.add(new Role("PATIENT"));

        return (args) -> {
            repository.save(new User(null, "admin", passwordEncoder.encode("admin123"), "admin@udevs.uz", roleSet));
            repository.save(new User(null, "patient", passwordEncoder.encode("patient123"), "patient@udevs.uz", roleSet2));
        };
    }
}
