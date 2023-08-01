package com.factory.demo.member.controller;

import com.factory.demo.member.dto.MemberCreateRequestDto;
import com.factory.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Long save(@RequestBody MemberCreateRequestDto requestDto) {
        return this.memberService.save(requestDto);
    }

}
