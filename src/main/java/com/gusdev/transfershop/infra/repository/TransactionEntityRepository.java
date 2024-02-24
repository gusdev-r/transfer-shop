package com.gusdev.transfershop.infra.repository;

import com.gusdev.transfershop.infra.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
