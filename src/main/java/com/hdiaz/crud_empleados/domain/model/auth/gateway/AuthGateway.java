package com.hdiaz.crud_empleados.domain.model.auth.gateway;

import com.hdiaz.crud_empleados.domain.model.auth.AuthResponse;
import com.hdiaz.crud_empleados.domain.model.auth.AuthenticationRequest;
import com.hdiaz.crud_empleados.domain.model.auth.User;

public interface AuthGateway {

    AuthResponse register(User user);
    AuthResponse authenticate(AuthenticationRequest authenticationRequest);

}
