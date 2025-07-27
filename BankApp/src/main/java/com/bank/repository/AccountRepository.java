package com.bank.repository;

import com.bank.model.Account;
import com.bank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * JPA Repository for the Account entity.
 * Provides standard CRUD operations and allows for custom query methods.
 */
@Repository // Marks this interface as a Spring Data JPA repository.
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Finds an Account by its account number.
     *
     * @param accountNumber The account number to search for.
     * @return An Optional containing the Account if found, or empty if not.
     */
    public Account findByAccountNumber(String accountNumber);

    /**
     * Finds all Accounts belonging to a specific User.
     *
     * @param authenticatedUser The User object whose accounts are to be retrieved.
     * @return A List of Accounts owned by the specified User.
     */
    List<Account> findByUser(User authenticatedUser);

    /**
     * Finds an Account by its ID and the User who owns it.
     * Useful for ensuring a user can only access their own accounts.
     *
     * @param id The ID of the account.
     * @param user The User object who is expected to own the account.
     * @return An Optional containing the Account if found and owned by the user, or empty if not.
     */
    Account findByIdAndUser(Long id, User user);
}
