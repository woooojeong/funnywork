package com.factory.demo.post.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.factory.demo.post.dto.PostListResponseDto;
import com.factory.demo.post.dto.PostResponseDto;
import com.factory.demo.post.dto.PostSaveRequestDto;
import com.factory.demo.post.dto.PostUpdateRequestDto;
import com.factory.demo.post.model.Post;
import com.factory.demo.post.repository.PostRepository;
import com.factory.demo.post.service.PostService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return this.postRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){

        Post post = this.postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        post.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Post post = this.postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        this.postRepository.delete(post);
    }

    @Override
    public PostResponseDto findById(Long id) {
        Post post = this.postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        return new PostResponseDto(post);
    }

    @Override
    @Transactional
    public List<PostListResponseDto> findAllDesc() {
        return this.postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }
}