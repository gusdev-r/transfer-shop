package com.gusdev.transfershop.entity;

import com.gusdev.transfershop.domain.enums.TransactionStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "tb_transactions")
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
    private LocalDateTime createAt;

    @Column(name = "updated_at")
    private LocalDateTime updateAt;
}

