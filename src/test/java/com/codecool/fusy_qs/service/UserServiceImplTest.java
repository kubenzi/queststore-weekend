package com.codecool.fusy_qs.service;

import com.codecool.UserNotFoundException;
import com.codecool.fusy_qs.entity.User;
import com.codecool.fusy_qs.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void should_delete_user(){
        // given:
        Long id = 1L;

        // when:
        userService.deleteUserById(id);

        // then:
        verify(userRepository, times(1)).deleteById(eq(id));
    }

    @Test(expected = UserNotFoundException.class)
    public void should_throw_exception_when_not_found() {
        // given:
        Long id = 324L;
        doThrow(UserNotFoundException.class).when(userRepository).deleteById(id);

        // when:
        userService.deleteUserById(id);

    }

    @Test
    public void should_match_valid_user(){
        // given:
        User user = new User("Przemek", "123");
        when(userService.getAllUsers()).thenReturn(createUsersSamples());

        // when:
        User userAfterValidation = userService.login(user).orElse(null);

        // then:
        assertNotNull(userAfterValidation);
    }

    @Test
    public void should_not_match_invalid_user(){
        // given:
        User user = new User("Przemek", "000");
        when(userService.getAllUsers()).thenReturn(createUsersSamples());

        // when:
        User userAfterValidation = userService.login(user).orElse(null);

        // then:
        assertNull(userAfterValidation);
    }


    private List<User> createUsersSamples() {
        return Arrays.asList(
                new User("Przemek", "123"),
                new User("Romek", "234")
        );
    }




}