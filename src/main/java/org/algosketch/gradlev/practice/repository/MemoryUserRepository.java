package org.algosketch.gradlev.practice.repository;

import org.algosketch.gradlev.practice.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryUserRepository implements UserRepository {
    private static Map<Long, User> store = new HashMap<>();
    private static Long curId = 0L;

    @Override
    public User save(User user) {
        user.setId(++curId);
        store.put(curId, user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<User> findByName(String name) {
        return store.values().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
