package jannkasper.spring.services;

import jannkasper.spring.api.model.BankAccountDTO;

import java.util.List;

public interface BankAccountService {

    List<BankAccountDTO> getAllAccounts();

    BankAccountDTO getAccountById(String id);

    BankAccountDTO getAccountByAccountNumber(String accountNumber);

    BankAccountDTO createNewAccount(BankAccountDTO bankAccountDTO);

    BankAccountDTO saveAccountByDTO(String id, BankAccountDTO bankAccountDTO);

    void deleteAccountById(String id);
}
