package com.app.SpringSecurityDemo.persistence.repository;

import com.app.SpringSecurityDemo.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
