package hm.binkley.labs

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
    @GetMapping("")
    fun all() = authors.findAll()

    @GetMapping("{id}")
    fun byId(@PathVariable id: String) = authors.findById(id)
        .orElseThrow { ResourceNotFoundException() }
}
