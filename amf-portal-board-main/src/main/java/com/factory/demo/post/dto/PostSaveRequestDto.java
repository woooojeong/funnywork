package com.factory.demo.post.dto;

import com.factory.demo.post.model.Author;
import com.factory.demo.post.model.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private Author author;

    @Builder
    public PostSaveRequestDto(String title, String content, Author author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
