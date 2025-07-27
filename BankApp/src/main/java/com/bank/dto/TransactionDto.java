package com.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto{

    private Long accountId;
    private String type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String description;
    private String status;

    // Constructors
    public TransactionDto() {}

    public TransactionDto(Long accountId, String type, BigDecimal amount, LocalDateTime timestamp, String description, String status) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters
    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

