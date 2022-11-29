package hm.binkley.labs

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.Comparator.comparing

@Table("BOOKS")
data class Book(
    @Id val id: String? = null,
    val isbn: String,
    val authorId: String,
    val title: String,
    val pages: Int,
    val moby: Boolean,
) : Comparable<Book> {
    override fun compareTo(other: Book): Int =
        comparing(Book::title)
            .thenComparing(Book::isbn)
            .compare(this, other)
}
