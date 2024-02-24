package com.gusdev.transfershop.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;

@Table(name = "tb_transaction_pin)")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TransactionPinEntity {

     @Column(name = "id")
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Column(name = "pin", nullable = false)
     private String pin;
     @Column(name = "attempt", nullable = false)
     private Integer attempt;
     @Column(name = "blocked", nullable = false)
     private Boolean blocked;
     @Column(name = "created_at", nullable = false)
     private LocalDateTime createdAt;
     @Column(name = "updated_at", nullable = false)
     private LocalDateTime updatedAt;

     public TransactionPinEntity(String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
          this.pin = pin;
          this.attempt = attempt;
          this.blocked = blocked;
          this.createdAt = createdAt;
          this.updatedAt = updatedAt;
     }

}
