package com.wiki.wiki.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Post {

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Column(length = 10000)
    private String text;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
