package hm.binkley.labs

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class GraphqlController(
    private val authors: AuthorRepository,
    private val books: BookRepository,
) {
    @QueryMapping
    fun bookByISBN(@Argument isbn: String): Book = books.findById(isbn).get()

    @SchemaMapping
    fun author(book: Book): Author = authors.findById(book.authorId).get()
}
