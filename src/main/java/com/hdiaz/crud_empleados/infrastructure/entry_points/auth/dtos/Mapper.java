package com.hdiaz.crud_empleados.infrastructure.entry_points.auth.dtos;

import com.hdiaz.crud_empleados.domain.model.auth.RegisterRequest;
import com.hdiaz.crud_empleados.domain.model.auth.User;

public class Mapper {

    public static User registerRequetToUser(RegisterRequest request){
        return User.builder()
                .nombre(request.getNombre())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
