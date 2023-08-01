package com.factory.demo.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginSuccessResultDto extends LoginResultDto {

    private Long id;
    private String name;
    private String email;

    public LoginSuccessResultDto(Long id, String name, String email) {
        super(true);
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
