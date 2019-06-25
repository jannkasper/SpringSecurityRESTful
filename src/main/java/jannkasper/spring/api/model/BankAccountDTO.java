package jannkasper.spring.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTO {

    private String id;
    private String accountNumber;
    private double balance;
    private String accountUrl;
}
