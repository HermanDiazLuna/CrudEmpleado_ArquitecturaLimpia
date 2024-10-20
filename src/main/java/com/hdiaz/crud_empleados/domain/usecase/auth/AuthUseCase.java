package com.hdiaz.crud_empleados.domain.usecase.auth;

import com.hdiaz.crud_empleados.domain.model.auth.AuthResponse;
import com.hdiaz.crud_empleados.domain.model.auth.Role;
import com.hdiaz.crud_empleados.domain.model.auth.User;
import com.hdiaz.crud_empleados.domain.model.auth.gateway.AuthGateway;
import com.hdiaz.crud_empleados.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AuthUseCase {

    private final AuthGateway authGateway;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public AuthResponse register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        var jwt = jwtService.generateToken(authGateway.register(user));
        return AuthResponse.builder().token(jwt).build();
    }

    public AuthResponse authenticate(){
        return null;
    }

}
