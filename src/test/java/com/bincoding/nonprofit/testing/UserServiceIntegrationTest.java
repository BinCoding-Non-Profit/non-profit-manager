package com.bincoding.nonprofit.testing;

import com.bincoding.nonprofit.entity.UserEntity;
import com.bincoding.nonprofit.repository.UserRepository;
import com.bincoding.nonprofit.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceIntegrationTest {

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    // write test cases here

    @Before
    public void setUp() {
        UserEntity john = new UserEntity();
        john.setUsername("johndoe@gmail.com");

        Mockito.when(userRepository.findByUsername(john.getUsername()))
                .thenReturn(java.util.Optional.of(john));
    }

    @Test
    public void whenValidNAme_thenUSerShouldBeFound(){
        String username = "johndoe@gmail.com";
        UserEntity found = userService.findByUsername(username).orElse(new UserEntity());

        assertThat(found.getUsername())
                .isEqualTo(username);

    }
}