package hm.binkley.labs.graphql

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("BOOKS")
data class Book(
    @Id val id: String? = null,
    val authorId: String,
    val title: String,
    val pageCount: Int,
    val moby: Boolean,
) {
    companion object {
        fun byId(id: String) = books.firstOrNull { it.id == id }
    }
}

private val books = listOf(
    Book(
        id = "book-1",
        authorId = "author-1",
        title = "Harry Potter and the Philosopher's Stone",
        pageCount = 223,
        moby = true,
    ),
    Book(
        id = "book-2",
        authorId = "author-2",
        title = "Moby Dick",
        pageCount = 635,
        moby = false
    ),
    Book(
        id = "book-3",
        authorId = "author-3",
        title = "Interview with the vampire",
        pageCount = 371,
        moby = false,
    ),
)
