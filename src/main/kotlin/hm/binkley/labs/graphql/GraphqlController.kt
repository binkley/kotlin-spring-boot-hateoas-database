package hm.binkley.labs.graphql

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
    fun bookById(@Argument id: String): Book? = books.findById(id).get()

    @SchemaMapping
    fun author(book: Book): Author = authors.findById(book.authorId).get()
}
