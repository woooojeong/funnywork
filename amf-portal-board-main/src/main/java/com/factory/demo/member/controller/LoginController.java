package com.factory.demo.member.controller;

import com.factory.demo.member.dto.MemberLoginRequestDto;
import com.factory.demo.member.dto.LoginResultDto;
import com.factory.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginController {

    private final MemberService memberService;

    @PostMapping
    public LoginResultDto save(@RequestBody MemberLoginRequestDto requestDto) {
        return this.memberService.login(requestDto);
    }

}
