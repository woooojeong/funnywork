package com.factory.demo.post.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.factory.demo.post.dto.PostResponseDto;
import com.factory.demo.post.service.PostService;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

     @GetMapping("/")
     public String index(Model model) {
         model.addAttribute("posts", postService.findAllDesc());
         return "index";
     }

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save"; // posts-save.mustache 호출
    }

    // 게시글 수정
    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostResponseDto dto = this.postService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}
