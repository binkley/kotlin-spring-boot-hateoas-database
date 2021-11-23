package hm.binkley.labs.hateoas

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("THINGIES")
data class Thingy(
    val text: String,
    val moby: Boolean,
    @Id val id: Long? = null,
)
