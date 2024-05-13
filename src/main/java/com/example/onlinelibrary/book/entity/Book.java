package com.example.onlinelibrary.book.entity;

import com.example.onlinelibrary.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String author;
    private int year;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
}
