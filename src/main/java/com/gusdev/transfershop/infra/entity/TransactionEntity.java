package com.gusdev.transfershop.infra.entity;

import com.gusdev.transfershop.core.domain.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "TB_TRANSACTIONS")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class TransactionEntity {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TO_WALLET")
    private WalletEntity toWallet;

    @ManyToOne
    @JoinColumn(name = "FROM_WALLET")
    private WalletEntity fromWallet;

    @Column(name = "TRANSACTION_VALUE", nullable = false)
    private BigDecimal value;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    public TransactionEntity(WalletEntity toWallet, WalletEntity fromWallet, BigDecimal value, TransactionStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.toWallet = toWallet;
        this.fromWallet = fromWallet;
        this.value = value;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

