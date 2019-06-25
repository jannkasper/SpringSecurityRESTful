package jannkasper.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private String login;
    private String password;
    private String customerName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinTable(name = "user_bankAccount",
            joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "bankAccount_id", referencedColumnName = "id") })
    private BankAccount bankAccount;


}
