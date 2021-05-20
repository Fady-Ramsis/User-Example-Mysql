package com.example.newExample.api.model.mapper;

import com.example.newExample.api.model.UserDataTransferForObject;
import com.example.newExample.domain.User;
import com.example.newExample.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapStructureTest {


    public static final String fName="ano";
    public static final String lName="mina";
    public static final String email="anomina@yahoo";
    public static final String password="ano1234";
    UserMapStructure userMapStructure= UserMapStructure.INSTANT;
    private UserRepository userRepository;



    @BeforeEach
    void setUp() {
    }

    @Test
    void userToUserDTO() throws Exception {

        User user = new User();
        user.setFname(fName);
        user.setLname(lName);
        user.setPassword(password);
        user.setEmail(email);

        user.setId(1L);
        UserDataTransferForObject userDataTransferForObject=userMapStructure.userToUserDTO(user);
        assertEquals(Long.valueOf(1L),userDataTransferForObject.getId());
        assertEquals(fName,userDataTransferForObject.getFname());
        assertEquals(lName,userDataTransferForObject.getLname());
        assertEquals(email,userDataTransferForObject.getEmail());
        assertEquals(password,userDataTransferForObject.getPassword());











    }
}