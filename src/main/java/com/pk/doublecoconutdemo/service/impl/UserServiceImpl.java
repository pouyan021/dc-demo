package com.pk.doublecoconutdemo.service.impl;

import com.pk.doublecoconutdemo.exception.UserAlreadyExistException;
import com.pk.doublecoconutdemo.model.entity.Role;
import com.pk.doublecoconutdemo.model.entity.User;
import com.pk.doublecoconutdemo.model.repository.UserRepository;
import com.pk.doublecoconutdemo.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;
    @Override
    public User save(User user) throws UserAlreadyExistException {
        Optional<User> savedUser = userRepository.findByUserName(user.getUserName());
        if (savedUser.isPresent()) {
            throw new UserAlreadyExistException("The user: " + user.getUserName() + " already exists.");
        }
        return userRepository.save(user);
    }

    @Override
    public void remove(int userId) {

    }

    @Override
    public Optional<User> getbyUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.get().getUserName(), user.get().getPassword(), getAuthorities(user.get().getRoles()));
    }

    private static List<GrantedAuthority> getAuthorities(Set<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }
}
