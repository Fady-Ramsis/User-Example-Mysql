package com.example.newExample.controller;

import com.example.newExample.api.model.UserDataTransferForObject;
import com.example.newExample.api.model.UserListDTO;
import com.example.newExample.domain.User;
import com.example.newExample.repository.UserRepository;
import com.example.newExample.service.UserService;;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "This is User controller")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/allusers")
    public String getAllUser(Model model){
        List<User>allUser=userRepository.findAll();
        model.addAttribute(allUser);
        return "jsonTemplate";


    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @GetMapping("/{id}")
    public String UserById(@PathVariable String id, Model model){
        model.addAttribute("USER BY ID",userService.findById(Long.parseLong(id)));
        return "jsonTemplate";

    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        userService.deleteById(Long.parseLong(id));
        return "jsonTemplate";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }
    @PostMapping("/adduser")
    public User newUser( User newUserVal){
        return userService.save(newUserVal);

    }
    @ApiOperation(value = "this is to get ALl User",notes = "Using Map structure")
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public UserListDTO getallUsers(){
        return new UserListDTO(userService.AllUsers());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDataTransferForObject createUser(@RequestBody UserDataTransferForObject userDTO){
        return  userService.createUser(userDTO);

    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDataTransferForObject updateUser(@PathVariable Long id,@RequestBody UserDataTransferForObject userDto){
        return userService.updateUser(id,userDto);

    }
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
      userService.deleteById(id);
    }








}
