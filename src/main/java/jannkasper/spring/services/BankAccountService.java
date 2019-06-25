package jannkasper.spring.services;

import jannkasper.spring.api.model.UserDTO;

import java.util.List;

public interface BankAccountService <T> {

    List<T> getAllAccounts();

    UserDTO getAccountById(String id);

    UserDTO getAccountByAccountNumber(String accountNumber);

    UserDTO createNewAccount(UserDTO userDTO);

    UserDTO saveAccountByDTO(String id, UserDTO userDTO);

    void deleteAccountById(String id);
}
