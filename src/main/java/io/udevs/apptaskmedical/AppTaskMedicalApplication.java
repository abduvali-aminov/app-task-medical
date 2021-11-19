package io.udevs.apptaskmedical;

import io.udevs.apptaskmedical.entity.User;
import io.udevs.apptaskmedical.enums.Role;
import io.udevs.apptaskmedical.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public CommandLineRunner demoUser(UserRepository repository) {
        return (args) -> {
            repository.save(new User(null, "admin", passwordEncoder.encode("admin123"), "admin@udevs.uz", Role.ADMIN));
            repository.save(new User(null, "patient", passwordEncoder.encode("patient123"), "patient@udevs.uz", Role.PATIENT));
        };
    }
}
