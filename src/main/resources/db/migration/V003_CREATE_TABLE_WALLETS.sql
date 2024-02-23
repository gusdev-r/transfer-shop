CREATE TABLE tb_wallets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(10, 2) NOT NULL,
    user_id UUID NOT NULL UNIQUE,
    transaction_pin_id BIGINT NOT NULL UNIQUE,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME,

    FOREIGN KEY (user_id) REFERENCES tb_users(id),
    FOREIGN KEY (transaction_pin_id) REFERENCES transaction_pin_id(id)
);