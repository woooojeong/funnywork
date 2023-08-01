package com.factory.demo.post.service;

import java.util.List;

import com.factory.demo.post.dto.PostListResponseDto;
import com.factory.demo.post.dto.PostResponseDto;
import com.factory.demo.post.dto.PostSaveRequestDto;
import com.factory.demo.post.dto.PostUpdateRequestDto;

public interface PostService {
    Long save(PostSaveRequestDto requestDto);
    Long update(Long id, PostUpdateRequestDto requestDto);
    void delete(Long id);
    PostResponseDto findById(Long id);
    List<PostListResponseDto> findAllDesc();
}
