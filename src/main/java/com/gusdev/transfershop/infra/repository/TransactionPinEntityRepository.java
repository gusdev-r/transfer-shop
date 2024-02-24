package com.gusdev.transfershop.infra.repository;

import com.gusdev.transfershop.infra.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
