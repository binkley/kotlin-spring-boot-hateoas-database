package hm.binkley.labs.graphql

data class Book(
    val id: String,
    val name: String,
    val pageCount: Int,
    val authorId: String,
) {
    companion object {
        fun byId(id: String) = books.firstOrNull { it.id == id }
    }
}

private val books = listOf(
    Book(
        "book-1",
        "Harry Potter and the Philosopher's Stone",
        223,
        "author-1"
    ),
    Book("book-2", "Moby Dick", 635, "author-2"),
    Book("book-3", "Interview with the vampire", 371, "author-3"),
)
