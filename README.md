# GRAPHQL DEMO
#

This is just a demo of using Spring Boot and GraphQL. 

#
#
## POSTMAN QUERY PAYLOAD
#

To get the query of books, use the following:

```
query {
    books {
        title
        author {
            firstName
            LastName
        }
    year
    }
}
```
