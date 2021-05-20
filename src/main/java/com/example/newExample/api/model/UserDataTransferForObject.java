package com.example.newExample.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataTransferForObject {

    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;



}
