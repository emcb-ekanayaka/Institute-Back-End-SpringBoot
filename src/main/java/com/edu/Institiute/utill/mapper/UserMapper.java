package com.edu.Institiute.utill.mapper;

import com.edu.Institiute.dto.UserDto;
import com.edu.Institiute.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToUserEntity(UserDto userDto);
}
