package com.easylearn.easylearn.model;

import com.easylearn.easylearn.model.enums.ParentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder // It does not work unless, there is a @AllArgsConstructor.
@AllArgsConstructor
public class ParentRespDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private ParentType type;
}
