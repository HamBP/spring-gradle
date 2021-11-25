package org.algosketch.gradlev.practice.service;

import org.algosketch.gradlev.practice.domain.User;
import org.algosketch.gradlev.practice.repository.MemoryUserRepository;
import org.algosketch.gradlev.practice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 회원가입
     */
    public Long join(User user) {
        validateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateUser(User user) {
        userRepository.findByName(user.getName()).ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<User> findUsers() {
       return userRepository.findAll();
    }

    public Optional<User> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
