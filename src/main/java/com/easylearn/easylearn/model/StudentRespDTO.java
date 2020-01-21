package com.easylearn.easylearn.model;

import com.easylearn.easylearn.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class StudentRespDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserType userType;
    private String role;

}
