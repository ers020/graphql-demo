package org.example.controller;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/graphql/mutation")
public class BooksMutationController implements GraphQLMutationResolver {
    private final BookService bookService;

    @MutationMapping
    public Book createBook(String title, String year, String firstName, String lastName) {
        return bookService.createBook(title, year, firstName, lastName);
    }
}
