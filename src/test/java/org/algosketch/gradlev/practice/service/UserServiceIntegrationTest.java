package org.algosketch.gradlev.practice.service;


import org.algosketch.gradlev.practice.domain.User;
import org.algosketch.gradlev.practice.repository.MemoryUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {
    @Autowired UserService memberService;

    @Test
    void join() {
        // given
        User member = new User();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        User result = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(result.getName());
    }

    @Test public void duplicated_회원_예외() {
        // given
        User member1 = new User();
        member1.setName("spring");

        // when
        User member2 = new User();
        member2.setName("spring");

        // then
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
    }
}
