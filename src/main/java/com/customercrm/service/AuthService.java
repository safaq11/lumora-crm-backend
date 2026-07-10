package com.customercrm.service;

import com.customercrm.dto.LoginRequest;
import com.customercrm.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

}