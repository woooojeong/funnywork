package com.factory.demo.post.model;

import com.factory.demo.cmn.model.AmfBaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Post extends AmfBaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private Author author;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
