package com.gusdev.transfershop.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_WALLETS")
public class WalletEntity {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "ID_USER")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "ID_TRANSACTION_PIN")
    private TransactionPinEntity transactionPinEntity;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    public WalletEntity(BigDecimal balance, UserEntity userEntity, TransactionPinEntity transactionPinEntity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.balance = balance;
        this.userEntity = userEntity;
        this.transactionPinEntity = transactionPinEntity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
