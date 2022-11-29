package hm.binkley.labs

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Pageable.unpaged
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rest/authors")
@RestController
class AuthorController(
    private val authors: AuthorRepository,
) {
    @GetMapping
    fun all(pageable: Pageable = unpaged()): Iterable<Author> =
        authors.findAll(pageable).content

    @GetMapping("{id}")
    fun byId(@PathVariable id: String): Author = authors.findById(id)
        .orElseThrow { ResourceNotFoundException() }
}
