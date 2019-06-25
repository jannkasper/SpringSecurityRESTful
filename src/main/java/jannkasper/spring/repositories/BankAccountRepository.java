package jannkasper.spring.repositories;

import jannkasper.spring.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {
    BankAccount findByAccountNumber(String accountNumber);
}
