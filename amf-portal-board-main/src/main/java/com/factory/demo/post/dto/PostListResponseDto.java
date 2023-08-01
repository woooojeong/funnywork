package com.factory.demo.post.dto;

import lombok.Getter;

import java.time.LocalDateTime;

import com.factory.demo.post.model.Post;

@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostListResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor().getAuthorName();
        this.modifiedDate = post.getModifiedDate();
    }
}
