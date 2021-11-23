package hm.binkley.labs.hateoas

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("THINGIES")
data class Thingy(
    @Id val id: String?,
    val text: String,
)
