package com.gusdev.transfershop.infra.repository;

import com.gusdev.transfershop.infra.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
    Boolean existsByTaxNumber(String taxNumber);
    Boolean existsByEmail(String email);
}
