package hm.binkley.labs.graphql

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("AUTHORS")
data class Author(
    @Id val id: String? = null,
    val firstName: String,
    val lastName: String,
) {
    companion object {
        fun byId(id: String) = authors.firstOrNull { it.id == id }
    }
}

private val authors = listOf(
    Author("author-1", "Joanne", "Rowling"),
    Author("author-2", "Herman", "Melville"),
    Author("author-3", "Anne", "Rice"),
)
