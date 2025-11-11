package org.mulu.pcms.config;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.mulu.pcms.entity.User;
import org.mulu.pcms.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        // Load .env variables
        Dotenv dotenv = Dotenv.load();

        String adminEmail = dotenv.get("ADMIN_EMAIL");
        String adminPassword = dotenv.get("ADMIN_PASSWORD");
        String adminUsername = dotenv.get("ADMIN_USERNAME");
        String adminFirstName = dotenv.get("ADMIN_FIRSTNAME");
        String adminLastName = dotenv.get("ADMIN_LASTNAME");

        if (adminEmail == null || adminPassword == null) {
            System.err.println("ADMIN_EMAIL or ADMIN_PASSWORD not set in .env file");
            return;
        }

        userRepository.findByEmail(adminEmail).ifPresentOrElse(
            user -> System.out.println("Admin user already exists."),
            () -> {
                User admin = new User();
                admin.setEmail(adminEmail);
                admin.setUsername(adminUsername);
                admin.setFirstName(adminFirstName);
                admin.setLastName(adminLastName);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setRole("ADMIN");
                admin.setDateCreated(LocalDate.now());
                userRepository.save(admin);
                System.out.println("Admin user created successfully!");
            }
        );
    }
}
