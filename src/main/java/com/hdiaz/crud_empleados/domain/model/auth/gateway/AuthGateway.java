package com.hdiaz.crud_empleados.domain.model.auth.gateway;

import com.hdiaz.crud_empleados.domain.model.auth.AuthResponse;
import com.hdiaz.crud_empleados.domain.model.auth.AuthenticationRequest;
import com.hdiaz.crud_empleados.domain.model.auth.User;
import com.hdiaz.crud_empleados.infrastructure.driven_adapters.auth.UserEntity;

public interface AuthGateway {

    UserEntity register(User user);
    AuthResponse authenticate(AuthenticationRequest authenticationRequest);

}
