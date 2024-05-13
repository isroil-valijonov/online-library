package com.example.onlinelibrary.comment.service;

import com.example.onlinelibrary.book.entity.Book;
import com.example.onlinelibrary.book.repository.BookRepository;
import com.example.onlinelibrary.comment.entity.Comment;
import com.example.onlinelibrary.comment.dto.CommentDto;
import com.example.onlinelibrary.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        return optionalComment.orElse(null);
    }

    public Comment saveComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setText(commentDto.getText());

        Book book = bookRepository.findById(commentDto.getBookId()).orElse(null);
        if (book == null) {
            throw new IllegalArgumentException("Kitob topilmadi!!!");
        }

        comment.setBook(book);
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
