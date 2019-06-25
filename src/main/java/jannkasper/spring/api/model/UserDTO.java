package jannkasper.spring.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String login;
    private String password;
    private String customerName;
    private String customerUrl;
}
