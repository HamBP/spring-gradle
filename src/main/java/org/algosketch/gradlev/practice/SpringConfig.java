package org.algosketch.gradlev.practice;

import org.algosketch.gradlev.practice.repository.MemoryUserRepository;
import org.algosketch.gradlev.practice.repository.UserRepository;
import org.algosketch.gradlev.practice.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }
}
