package com.gusdev.transfershop.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "TB_TRANSACTION_PIN")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TransactionPinEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ID")
     private Long id;
     @Column(name = "PIN", nullable = false)
     private String pin;
     @Column(name = "ATTEMPT", nullable = false)
     private Integer attempt;
     @Column(name = "BLOCKED", nullable = false)
     private Boolean blocked;
     @Column(name = "CREATED_AT", nullable = false)
     private LocalDateTime createdAt;
     @Column(name = "UPDATED_AT", nullable = false)
     private LocalDateTime updatedAt;

     public TransactionPinEntity(String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.pin = pin;
          this.attempt = attempt;
          this.blocked = blocked;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

}
