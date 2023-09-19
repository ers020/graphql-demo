package org.example.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.model.Author;
import org.example.model.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class BookService {
    private static final Long MIN = 5L;
    private static final Long MAX = 100000L;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Transactional
    public Book createBook(String title, String year, String firstName, String lastName) {
        final Long id = getId();
        final Author author = Author.builder()
                .firstName(firstName)
                .id(id)
                .lastName(lastName)
                .build();

        final Book book = Book.builder()
                .author(author)
                .id(getId())
                .title(title)
                .year(Integer.parseInt(year))
                .build();

        authorRepository.save(author);
        bookRepository.save(book);

        return book;
    }

    private Long getId() {
        Random random = new Random();
        return random.nextLong() % (MAX - MIN + 1) + MAX;
    }
}
