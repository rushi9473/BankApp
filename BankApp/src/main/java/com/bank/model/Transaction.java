package com.bank.model;




import jakarta.persistence.*;
import java.math.BigDecimal; // For transaction amount.
import java.time.LocalDateTime; // For modern date and time handling (Java 8 feature).

/**
 * Represents a financial transaction (deposit, withdrawal, transfer) on an account.
 */
@Entity
public class Transaction {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)  
    @JoinColumn(name = "account_id", nullable = false)
    private Account account; 
    private String type;
    private BigDecimal amount;
    private LocalDateTime timestamp; 
    private String description; 
    private String status;
    
    
    
    
    
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
    

    // Note: No explicit getters/setters/constructors are needed due to Lombok annotations.
}

