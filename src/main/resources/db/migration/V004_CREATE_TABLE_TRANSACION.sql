CREATE TABLE tb_transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    from_wallet BIGINT NOT NULL,
    to_wallet BIGINT NOT NULL,
    transaction_value DECIMAL (10, 2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME,

    FOREIGN KEY (from_wallet) REFERENCES tb_wallets(id)
    FOREIGN KEY (to_wallet) REFERENCES tb_wallets(id)
);