package com.pk.doublecoconutdemo.service.impl;

import com.pk.doublecoconutdemo.exception.UserAlreadyExistException;
import com.pk.doublecoconutdemo.model.entity.User;
import com.pk.doublecoconutdemo.model.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User()
                .setUserName("pouyan")
                .setPassword("123456")
                .setCreateDate(Instant.now());
    }

    @Test
    void givenUserObject_whenSaveUser_thenReturnUser() throws UserAlreadyExistException {
        //given
        given(userRepository.save(user)).willReturn(user);

        //when
        User savedUser = userService.save(user);

        //then
        assertThat(savedUser).isNotNull();

    }

    @Test
    void givenUserObject_whenSaveUser_throwsException() {
        //given
        given(userRepository.findByUserName(user.getUserName())).willReturn(Optional.of(user));

        //when
        assertThrows(UserAlreadyExistException.class, () -> userService.save(user));

        //then
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void givenUserObject_whenGetByUsername_thenReturnUser() {
        //given
        given(userRepository.findByUserName(user.getUserName())).willReturn(Optional.of(user));
        //when
        User savedUser = userService.getbyUserName(user.getUserName()).get();
        //then
        assertThat(savedUser).isNotNull();
    }
}
