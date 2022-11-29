package hm.binkley.labs

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Pageable.unpaged
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rest/books")
@RestController
class BookController(
    private val books: BookRepository,
) {
    @GetMapping
    fun all(pageable: Pageable = unpaged()): Iterable<Book> =
        books.findAll(pageable).content

    @GetMapping("{isbn}")
    fun byISBN(@PathVariable isbn: String): Book = books.findById(isbn)
        .orElseThrow { ResourceNotFoundException() }
}
