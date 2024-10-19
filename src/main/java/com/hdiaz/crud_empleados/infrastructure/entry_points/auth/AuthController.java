package com.hdiaz.crud_empleados.infrastructure.entry_points.auth;

import com.hdiaz.crud_empleados.domain.model.auth.AuthResponse;
import com.hdiaz.crud_empleados.domain.model.auth.RegisterRequest;
import com.hdiaz.crud_empleados.domain.usecase.auth.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthUseCase authUseCase;

    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authUseCase.register(registerRequest));
    }

}
