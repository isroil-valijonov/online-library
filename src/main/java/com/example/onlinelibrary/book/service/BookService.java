package com.example.onlinelibrary.book.service;

import com.example.onlinelibrary.book.dto.BookDto;
import com.example.onlinelibrary.book.entity.Book;
import com.example.onlinelibrary.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService{
    private final BookRepository bookRepository;

    public Book addBook(BookDto bookDto) {
        Book book = new Book();
        book.setDescription(bookDto.getDescription());
        book.setAuthor(bookDto.getAuthor());
        book.setYear(bookDto.getYear());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, BookDto bookDto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setDescription(bookDto.getDescription());
            book.setAuthor(bookDto.getAuthor());
            book.setYear(bookDto.getYear());
            return bookRepository.save(book);
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

}
