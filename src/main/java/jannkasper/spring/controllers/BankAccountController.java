package jannkasper.spring.controllers;

import jannkasper.spring.api.model.BankAccountDTO;
import jannkasper.spring.api.model.ListDTO;
import jannkasper.spring.services.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankAccountController {

    public static final String BASE_URL = "/api/account";

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListDTO<BankAccountDTO> getListOfUsers() {
        return new ListDTO<BankAccountDTO>(bankAccountService.getAllAccounts());
    }

    @GetMapping({BASE_URL + "/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public BankAccountDTO getUserById (@PathVariable String id) {
        return bankAccountService.getAccountById(id);
    }
    @GetMapping({BASE_URL + "/{accountNumber}"})
    @ResponseStatus(HttpStatus.OK)
    public BankAccountDTO getUserByAccountNumber (@PathVariable String accountNumber) {
        return bankAccountService.getAccountByAccountNumber(accountNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankAccountDTO createAccount (@RequestBody BankAccountDTO bankAccountDTO){
        return bankAccountService.createNewAccount(bankAccountDTO);
    }

    @PutMapping({BASE_URL + "/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public BankAccountDTO updateAccount (@PathVariable String id, @RequestBody BankAccountDTO bankAccountDTO){
        return bankAccountService.saveAccountByDTO(id, bankAccountDTO);
    }


    @DeleteMapping({BASE_URL + "/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable String id){
        bankAccountService.deleteAccountById(id);
    }

}

