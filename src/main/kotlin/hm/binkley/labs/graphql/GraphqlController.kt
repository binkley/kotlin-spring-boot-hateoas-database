package hm.binkley.labs.graphql

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class GraphqlController {
    @QueryMapping
    fun bookById(@Argument id: String) = Book.byId(id)

    @SchemaMapping
    fun author(book: Book) = Author.byId(book.authorId)
}
