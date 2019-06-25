package jannkasper.spring.api.mapper;

import jannkasper.spring.api.model.UserDTO;
import jannkasper.spring.domain.User;
import org.mapstruct.MapperConfig;

@MapperConfig
public interface UserMapper {

    UserDTO convertToDto (User user);

    User convertToEntity (UserDTO userDTO);

}

