package jannkasper.spring.services;

import jannkasper.spring.api.mapper.UserMapper;
import jannkasper.spring.api.model.UserDTO;
import jannkasper.spring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getUserById(String id) {
        return null;
    }

    @Override
    public UserDTO getUserByCustomerName(String customerName) {
        return null;
    }

    @Override
    public UserDTO getUserByLogin(String login) {
        return null;
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO saveUserByDTO(String id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUserById(String id) {

    }
}
