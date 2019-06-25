package jannkasper.spring.services;

import jannkasper.spring.api.mapper.UserMapper;
import jannkasper.spring.api.model.UserDTO;
import jannkasper.spring.domain.User;
import jannkasper.spring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        userRepository
                .findAll()
                .stream()
                .map(user -> {
                    UserDTO userDTO = userMapper.convertToDto(user);
                    userDTO.setCustomerUrl(getCustomerUrl(user.getId().toString()));
                    return userDTO;
                })
                .collect(Collectors.toList());
        return null;
    }

    @Override
    public UserDTO getUserById(String id) {
        return userRepository
                .findById(UUID.fromString(id))
                .map(userMapper::convertToDto)
                .map(userDTO -> {
                    userDTO.setCustomerUrl(getCustomerUrl(id));
                    return userDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserDTO getUserByCustomerName(String customerName) {
        return userRepository
                .findByCustomerName(customerName)
                .map(userMapper::convertToDto)
                .map(userDTO -> {
                    userDTO.setCustomerUrl(getCustomerUrl(userDTO.getId()));
                    return userDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserDTO getUserByLogin(String login) {
        return userRepository
                .findByLogin(login)
                .map(userMapper::convertToDto)
                .map(userDTO -> {
                    userDTO.setCustomerUrl(getCustomerUrl(userDTO.getId()));
                    return userDTO;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        return saveAndReturnDTO(userMapper.convertToEntity(userDTO));
    }
    private UserDTO saveAndReturnDTO(User user){
        User savedUser = userRepository.save(user);

        UserDTO returnDTO = userMapper.convertToDto(savedUser);

        returnDTO.setCustomerUrl(getCustomerUrl(savedUser.getId().toString()));

        return returnDTO;
    }

    @Override
    public UserDTO saveUserByDTO(String id, UserDTO userDTO) {
        User user = userMapper.convertToEntity(userDTO);
        user.setId(UUID.fromString(id));

        return saveAndReturnDTO(user);
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(UUID.fromString(id));

    }
    private String getCustomerUrl(String id) {
        return UserController.BASE_URL + "/user/" + id;
    }
}
