package com.example.newExample.service;

import com.example.newExample.api.model.UserDataTransferForObject;
import com.example.newExample.api.model.UserListDTO;
import com.example.newExample.domain.User;

import java.util.List;


public interface UserService {
    List<User>findByFirstName(String firstname);
    List<UserDataTransferForObject> AllUsers();
    UserDataTransferForObject findById(long l);
    void deleteById(long deleteId);
    User save(User newUser);
    UserDataTransferForObject createUser(UserDataTransferForObject userDTO);
    UserDataTransferForObject updateUser(Long id , UserDataTransferForObject userDto);

}
