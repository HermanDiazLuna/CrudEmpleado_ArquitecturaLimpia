package com.hdiaz.crud_empleados.domain.usecase.auth;

import com.hdiaz.crud_empleados.domain.model.auth.AuthResponse;
import com.hdiaz.crud_empleados.domain.model.auth.RegisterRequest;
import com.hdiaz.crud_empleados.domain.model.auth.User;
import com.hdiaz.crud_empleados.domain.model.auth.gateway.AuthGateway;
import com.hdiaz.crud_empleados.domain.model.auth.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AuthUseCase {

    private final AuthGateway authGateway;

    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request){
        var user = User.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        return authGateway.register(user);
    }

    public AuthResponse authenticate(){
        return null;
    }

}
