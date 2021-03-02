package com.bincoding.nonprofit.testing;

import com.bincoding.nonprofit.NonprofitApplication;
import com.bincoding.nonprofit.config.JwtTokenUtil;
import com.bincoding.nonprofit.controller.UserController;
import com.bincoding.nonprofit.entity.UserEntity;
import com.bincoding.nonprofit.repository.UserRepository;
import com.bincoding.nonprofit.service.JwtUserDetailsService;
import com.bincoding.nonprofit.service.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =
        WebEnvironment.MOCK,
        classes = NonprofitApplication.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
//@TestPropertySource(
//        locations = "classpath:application-integrationtest.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @After
    public void resetDb() {
        service.deleteAll();
    }

    // write test cases here

    @Test
    public void whenValidInput_thenRegisterUser() throws IOException, Exception {
        service.deleteByUsername("johndoe@test.com");

        UserEntity john = new UserEntity();
        john.setUsername("johndoe@test.com");
        john.setPassword("test123");

        mvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(john)));

//        List<UserEntity> found = service.findAll();
//        assertThat(found).extracting(UserEntity::getUsername).containsOnlyOnce("johndoe@test.com");
    }
    @Test
    public void whenValidInput_thenAuthenticateUser() throws IOException, Exception {

//        createTestUsers("admin", "admin", "ROLE_ADMIN");
//        UserEntity admin = new UserEntity();
//        admin.setUsername("admin");
//        admin.setPassword("admin");

//        mvc.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(admin)))
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.jwttoken").exists());

//        List<UserEntity> found = service.findAll();
//        assertThat(found).extracting(UserEntity::getUsername).containsOnlyOnce("johndoe@test.com");
    }

    @Test
    public void givenUsers_whenGetUsers_thenReturnJsonArray()
            throws Exception {

        createTestUsers("admin", "admin", "ROLE_ADMIN");
        createTestUsers("haris", "haris","ROLE_USER");
        createTestUsers("bilal", "bilal", "ROLE_USER");

        String authToken = authenticateUser("admin", "admin");

        mvc.perform(get("/api/users")
                .header("Authorization", "Bearer " + authToken)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(3))));
//                .andExpect(jsonPath("$.[1]", is("bilal")))
//                .andExpect(jsonPath("$.[0]", is("haris")));

    }

    private void createTestUsers(String username, String password, String roles) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setRoles(roles);
        repository.saveAndFlush(user);
    }

    private String authenticateUser(String username, String password) throws Exception {
        authenticate(username, password);

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        return jwtTokenUtil.generateToken(userDetails);
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
