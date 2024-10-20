package com.hdiaz.crud_empleados.infrastructure.driven_adapters.auth;

import com.hdiaz.crud_empleados.domain.model.auth.AuthResponse;
import com.hdiaz.crud_empleados.domain.model.auth.AuthenticationRequest;
import com.hdiaz.crud_empleados.domain.model.auth.User;
import com.hdiaz.crud_empleados.domain.model.auth.gateway.AuthGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserAdapter implements AuthGateway {

    private final UserRepository userRepository;

    @Override
    public UserEntity register(User user) {
        return this.userRepository.save(userEntity(user));
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest authenticationRequest) {
        return null;
    }

    private UserEntity userEntity(User user){
        return UserEntity.builder()
                .nombre(user.getNombre())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }


}
