package com.zest.employee_management.service.Auth;

import com.zest.employee_management.dto.AuthResponse;
import com.zest.employee_management.dto.LoginRequest;
import com.zest.employee_management.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}