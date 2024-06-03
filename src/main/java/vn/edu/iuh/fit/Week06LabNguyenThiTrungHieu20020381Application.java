package vn.edu.iuh.fit;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.UserRepository;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Week06LabNguyenThiTrungHieu20020381Application {

    public static void main(String[] args) {
        SpringApplication.run(Week06LabNguyenThiTrungHieu20020381Application.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            Faker faker = new Faker();
            for (int i = 0; i < 20; i++) {

                User user = new User(faker.phoneNumber().cellPhone(),
                        Instant.now(),
                        faker.name().lastName(),
                        faker.lorem().sentence(),
                        faker.lorem().sentence(),
                        faker.date().past(30, TimeUnit.DAYS).toInstant(),
                        faker.internet().password(),
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.internet().emailAddress());
                userRepository.save(user);
            }
        };
    }

}
