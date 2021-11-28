package org.algosketch.gradlev.practice.repository;

import org.algosketch.gradlev.practice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<User, Long>, UserRepository {
    @Override
    Optional<User> findByName(String name);
}
