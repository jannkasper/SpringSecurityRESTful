package jannkasper.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Random;

@Entity
@Getter
@Setter
@Table(name = "bankAccount")
public class BankAccount extends BaseEntity {

    private String accountNumber;
    private double balance;

    @OneToOne (mappedBy = "bankAccount")
    private User customer;

    public BankAccount(){
        Random rand = new Random();
        String card = "NL";
        for (int i = 0; i < 14; i++)
        {
            int n = rand.nextInt(10) + 0;
            card += Integer.toString(n);
        }

        this.accountNumber = card;
        this.balance = 0;
    }

    void addToAccount(double amount){
        this.balance = balance + amount;
    }
}
