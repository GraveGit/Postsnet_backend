package org.postsnet.mapper;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.postsnet.dto.SignUpDTO;
import org.postsnet.dto.UserDTO;
import org.postsnet.entity.User;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDTOToUser(UserDTO dto);

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "passwordHash", target = "passwordHash"),
            @Mapping(source = "createdAt", target = "createdAt")
    })
    UserDTO userToUserDTO(User user);

    //@Mapping(target = "passwordHash", ignore = true)

    @Mappings({
            @Mapping(source = "login", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(target = "passwordHash", ignore = true)
    })
    User signUpToUser(SignUpDTO signUpDTO);
}
