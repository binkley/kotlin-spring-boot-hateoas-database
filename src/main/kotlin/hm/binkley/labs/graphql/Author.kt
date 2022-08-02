package hm.binkley.labs.graphql

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("AUTHORS")
data class Author(
    @Id val id: String? = null,
    val firstName: String,
    val lastName: String,
)
