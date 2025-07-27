package com.bank.repository;

import com.bank.model.Account;
import com.bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository // Marks this interface as a Spring Data JPA repository.
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    
    List<Transaction> findByAccountOrderByTimestampDesc(Account account);

    
    Transaction findTopByAccountOrderByTimestampDesc(Account account);
}
