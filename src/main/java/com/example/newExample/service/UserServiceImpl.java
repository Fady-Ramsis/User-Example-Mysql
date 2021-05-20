package com.example.newExample.service;

import com.example.newExample.api.model.UserDataTransferForObject;
import com.example.newExample.api.model.mapper.UserMapStructure;
import com.example.newExample.domain.User;
import com.example.newExample.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserMapStructure userMapStructure;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapStructure userMapStructure, UserRepository userRepository) {
        this.userMapStructure = userMapStructure;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findByFirstName(String firstname) {
        return null;
    }

    @Override
    public List<UserDataTransferForObject> AllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapStructure::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDataTransferForObject findById(long l) {
        return  userRepository.findById(l)
                .map(userMapStructure::userToUserDTO)
                .map(userDataTransferForObject -> {
                    return userDataTransferForObject;
                }).orElseThrow(ResourceNotfoundException::new);
    }


    @Override
    public void deleteById(long deleteId) {

        userRepository.deleteById(deleteId);
    }

    @Override
    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public UserDataTransferForObject createUser(UserDataTransferForObject userDto) {

        User user=UserMapStructure.INSTANT.UserDtoTOUser(userDto);
        User saveUser= userRepository.save(user);
        UserDataTransferForObject userDto2=UserMapStructure.INSTANT.userToUserDTO(saveUser);
        return userDto2;

    }

    @Override
    public UserDataTransferForObject updateUser(Long id, UserDataTransferForObject userDto) {
        User user=UserMapStructure.INSTANT.UserDtoTOUser(userDto);
        User saveuser=userRepository.save(user);
        UserDataTransferForObject userDt=UserMapStructure.INSTANT.userToUserDTO(saveuser);
        user.setId(id);
        return userDt;
    }
}
