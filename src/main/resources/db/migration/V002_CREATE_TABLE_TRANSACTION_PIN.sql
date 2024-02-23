CREATE TABLE tb_transaction_pin (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pin VARCHAR(50) NOT NULL,
    attempt INT NOT NULL,
    blocked_bool NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME
);