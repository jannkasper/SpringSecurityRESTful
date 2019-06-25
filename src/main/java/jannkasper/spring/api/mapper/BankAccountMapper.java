package jannkasper.spring.api.mapper;

import jannkasper.spring.api.model.BankAccountDTO;
import jannkasper.spring.domain.BankAccount;
import org.mapstruct.MapperConfig;

@MapperConfig
public interface BankAccountMapper {

    BankAccountDTO convertToDto (BankAccount bankAccount);

    BankAccount convertToEntity (BankAccountDTO bankAccountDTO);

}

