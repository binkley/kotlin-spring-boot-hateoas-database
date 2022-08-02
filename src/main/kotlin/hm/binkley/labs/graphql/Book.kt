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
)
