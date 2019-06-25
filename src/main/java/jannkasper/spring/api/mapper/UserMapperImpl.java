package jannkasper.spring.api.mapper;

import jannkasper.spring.api.model.UserDTO;
import jannkasper.spring.domain.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO convertToDto(User user) {
        if(user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId().toString());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setCustomerName(user.getCustomerName());

        return userDTO;
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }
        User user = new User();
        user.setId(UUID.fromString(userDTO.getId()));
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setCustomerName(userDTO.getCustomerName());

        return user;
    }
}
