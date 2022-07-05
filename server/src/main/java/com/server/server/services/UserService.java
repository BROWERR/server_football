package com.server.server.services;

import com.server.server.exceptions.UserExistException;
import com.server.server.models.User;
import com.server.server.payload.request.SignupRequest;
import com.server.server.repository.UserRepository;
import com.server.server.security.JWTTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getCurrentUser(Principal principal){
        return userRepository.findUserByUsername(principal.getName()).orElseThrow(()-> new UsernameNotFoundException(
                "User not found with username:" + principal.getName()
        ));
    }

    public User getUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(()->new UsernameNotFoundException(
                "User not found"
        ));
    }

    public User createUser(SignupRequest userIn) {
        User user = new User();
        user.setUsername(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.setRole(0);

        try {
            LOG.info("Saving User {}", userIn.getUsername());
            return userRepository.save(user);
        } catch (Exception e) {
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + user.getUsername() + " already exist. Please check credentials");
        }
    }
}
