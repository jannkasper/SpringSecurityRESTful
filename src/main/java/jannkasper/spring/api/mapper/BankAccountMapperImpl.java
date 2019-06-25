package jannkasper.spring.api.mapper;

import jannkasper.spring.api.model.BankAccountDTO;
import jannkasper.spring.domain.BankAccount;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BankAccountMapperImpl implements BankAccountMapper {
    @Override
    public BankAccountDTO convertToDto(BankAccount bankAccount) {
        if(bankAccount == null) {
            return null;
        }
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setId(bankAccount.getId().toString());
        bankAccountDTO.setAccountNumber(bankAccount.getAccountNumber());
        bankAccountDTO.setBalance(bankAccount.getBalance());

        return bankAccountDTO;
    }

    @Override
    public BankAccount convertToEntity(BankAccountDTO bankAccountDTO) {
        if(bankAccountDTO == null) {
            return null;
        }
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(UUID.fromString(bankAccountDTO.getId()));
        bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
        bankAccount.setBalance(bankAccountDTO.getBalance());

        return bankAccount;
    }
}
