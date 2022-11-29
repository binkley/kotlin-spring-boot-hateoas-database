package hm.binkley.labs

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.Comparator.comparing

@Table("AUTHORS")
data class Author(
    @Id val id: String? = null,
    val firstName: String,
    val lastName: String,
) : Comparable<Author> {
    override fun compareTo(other: Author): Int =
        comparing(Author::lastName)
            .thenComparing(Author::firstName)
            .compare(this, other)
}
