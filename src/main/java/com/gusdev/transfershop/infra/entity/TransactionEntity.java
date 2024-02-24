package com.gusdev.transfershop.infra.entity;

import com.gusdev.transfershop.core.domain.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "tb_transactions")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class TransactionEntity {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "to_wallet")
    private WalletEntity toWallet;

    @ManyToOne
    @JoinColumn(name = "from_wallet")
    private WalletEntity fromWallet;

    @Column(name = "transaction_value", nullable = false)
    private BigDecimal value;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
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

