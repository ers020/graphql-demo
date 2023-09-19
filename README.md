# GRAPHQL DEMO
#

This is just a demo of using Spring Boot and GraphQL. 

#
#
## POSTMAN QUERY PAYLOAD
#
Endpoint: `http://localhost:8080/graphql`
#
To get the query of books, use the following:

```
query {
    getBooks {
        title
        author {
            firstName
            LastName
        }
    year
    }
}
```

To get a book by a title, use the following:

```
query {
    getBooksByTitle(title: "YourTitleHere") {
        title
        author {
            firstName
            LastName
        }
        year
    }
}
```
#
## POSTMAN MUTATION PAYLOAD
#
Endpoint `http://localhost:8080/graphql/mutation`
#
To save the mutation of books/author, use the following:
```
mutation {
    createBook(title: "title", year: "year, firstName: "firstName", lastName: "lastName") {
        title
        author {
            firstName
            LastName
        }
        year
    }
}
```
