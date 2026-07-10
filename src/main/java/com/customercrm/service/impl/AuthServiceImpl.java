package com.customercrm.service.impl;

import org.springframework.stereotype.Service;

import com.customercrm.dto.LoginRequest;
import com.customercrm.dto.LoginResponse;
import com.customercrm.entity.User;
import com.customercrm.repository.UserRepository;
import com.customercrm.service.AuthService;
import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        LoginResponse response = new LoginResponse();

        User user = userRepository.findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {

            response.setSuccess(false);
            response.setMessage("Invalid Username");

            return response;
        }

        if (!user.getPassword().equals(request.getPassword())) {

            response.setSuccess(false);
            response.setMessage("Invalid Password");

            return response;
        }
        user.setLastLogin(LocalDateTime.now());

        userRepository.save(user);

        response.setSuccess(true);
        response.setMessage("Login Successful");
        response.setUsername(user.getUsername());
        response.setFullName(user.getFullName());
        response.setRole(user.getRole());

        return response;
    }

}