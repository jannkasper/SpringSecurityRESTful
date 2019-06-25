package jannkasper.spring.services;

import jannkasper.spring.api.model.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(String id);

    UserDTO getUserByCustomerName(String customerName);

    UserDTO getUserByLogin(String login);

    UserDTO createNewUser(UserDTO userDTO);

    UserDTO saveUserByDTO(String id, UserDTO userDTO);

    void deleteUserById(String id);
}
