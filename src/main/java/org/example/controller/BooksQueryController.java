package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequiredArgsConstructor
public class BooksQueryController {
    private final BookService bookService;

    @QueryMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @QueryMapping
    public List<Book> getBooksByTitle(@Argument String title) {
        return bookService.searchBooksByTitle(title);
    }

    @MutationMapping
    public Book createBook(@Argument String title,@Argument String year,@Argument String firstName,@Argument String lastName) {
        return bookService.createBook(title, year, firstName, lastName);
    }
}
