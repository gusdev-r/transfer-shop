package com.gusdev.transfershop.core.domain;

import com.gusdev.transfershop.core.domain.enums.UserType;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserType userType;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public User(UUID id, String email, String password, TaxNumber taxNumber, String fullName, UserType userType, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.userType = userType;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public User(String email, String password, TaxNumber taxNumber, String fullName, UserType userType) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.userType = userType;
        this.createdAt = LocalDateTime.now();
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserType getType() {
        return userType;
    }

    public void setType(UserType type) {
        this.userType = type;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!getId().equals(user.getId())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getTaxNumber().equals(user.getTaxNumber())) return false;
        if (!getFullName().equals(user.getFullName())) return false;
        if (getType() != user.getType()) return false;
        if (!getCreatedAt().equals(user.getCreatedAt())) return false;
        return getUpdateAt() != null ? getUpdateAt().equals(user.getUpdateAt()) : user.getUpdateAt() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getTaxNumber().hashCode();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdateAt() != null ? getUpdateAt().hashCode() : 0);
        return result;
    }
}
