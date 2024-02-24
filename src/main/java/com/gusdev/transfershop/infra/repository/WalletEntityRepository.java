package com.gusdev.transfershop.infra.repository;

import com.gusdev.transfershop.infra.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
    WalletEntity findByUserEntityTaxNumber(String taxNumber);
}
