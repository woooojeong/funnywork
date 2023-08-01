package com.factory.demo.member.dto;

import com.factory.demo.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateRequestDto {

    private String name;
    private String nickname;
    private String email;
    private String password;

    @Builder
    public MemberCreateRequestDto(String name, String nickname, String email, String password) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .email(email)
                .password(password)
                .build();
    }

}
