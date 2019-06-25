package jannkasper.spring.services;

import jannkasper.spring.api.mapper.BankAccountMapper;
import jannkasper.spring.api.model.BankAccountDTO;
import jannkasper.spring.api.model.UserDTO;
import jannkasper.spring.domain.BankAccount;
import jannkasper.spring.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    BankAccountRepository bankAccountRepository;
    BankAccountMapper bankAccountMapper;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }

    @Override
    public List<BankAccountDTO> getAllAccounts() {
        return  bankAccountRepository
                .findAll()
                .stream()
                .map(bankAccount -> {
                    BankAccountDTO bankAccountDTO = bankAccountMapper.convertToDto(bankAccount);
                    bankAccountDTO.setAccountUrl(getCustomerUrl(bankAccount.getId().toString()));
                    return bankAccountDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BankAccountDTO getAccountById(String id) {
        return bankAccountRepository
                .findById(UUID.fromString(id))
                .map(bankAccountMapper::convertToDto)
                .map(bankAccountDTO -> {
                    bankAccountDTO.setAccountUrl(getCustomerUrl(bankAccountDTO.getId().toString()));
                    return bankAccountDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public BankAccountDTO getAccountByAccountNumber(String accountNumber) {
        return bankAccountRepository
                .findByAccountNumber(accountNumber)
                .map(bankAccountMapper::convertToDto)
                .map(bankAccountDTO -> {
                    bankAccountDTO.setAccountUrl(getCustomerUrl(bankAccountDTO.getId().toString()));
                    return bankAccountDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public BankAccountDTO createNewAccount(BankAccountDTO bankAccountDTO) {
        return saveAndReturnDTO(bankAccountMapper.convertToEntity(bankAccountDTO));
    }

    private BankAccountDTO saveAndReturnDTO(BankAccount bankAccount){
        BankAccount bankAccountSaved = bankAccountRepository.save(bankAccount);

        BankAccountDTO bankAccountDTO =  bankAccountMapper.convertToDto(bankAccountSaved);

        bankAccountDTO.setAccountUrl(bankAccountSaved.getId().toString());

        return bankAccountDTO;
    }

    @Override
    public BankAccountDTO saveAccountByDTO(String id, BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount = bankAccountMapper.convertToEntity(bankAccountDTO);
        bankAccount.setId(UUID.fromString(id));

        return saveAndReturnDTO(bankAccount);
    }

    @Override
    public void deleteAccountById(String id) {
        bankAccountRepository.deleteById(UUID.fromString(id));

    }

    private String getCustomerUrl(String id) {
        return UserController.BASE_URL + "/account/" + id;
    }
}
