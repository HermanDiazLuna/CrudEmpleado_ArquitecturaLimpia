package com.hdiaz.crud_empleados.infrastructure.driven_adapters.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
