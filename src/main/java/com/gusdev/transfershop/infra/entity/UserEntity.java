package com.gusdev.transfershop.infra.entity;

import com.gusdev.transfershop.core.domain.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "TB_USERS")
@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "TAX_NUMBER", nullable = false)
    private String taxNumber;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;



}
