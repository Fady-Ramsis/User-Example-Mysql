package com.example.newExample.api.model.mapper;

import com.example.newExample.api.model.UserDataTransferForObject;
import com.example.newExample.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapStructure {

    UserMapStructure INSTANT= Mappers.getMapper(UserMapStructure.class);

    UserDataTransferForObject userToUserDTO(User user);

    User UserDtoTOUser(UserDataTransferForObject userDTO);


}
