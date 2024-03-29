package hm.binkley.labs

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.json.JacksonTester
import org.springframework.boot.test.web.server.LocalServerPort
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpClient.Redirect.ALWAYS
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers.ofString

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureJsonTesters
internal class MainIT(
    @LocalServerPort private val port: Int,
    @Autowired private val authorJson: JacksonTester<Author>,
    @Autowired private val authorsJson: JacksonTester<List<Author>>,
    @Autowired private val bookJson: JacksonTester<Book>,
    @Autowired private val booksJson: JacksonTester<List<Book>>,
) {
    @Test
    fun `should have an endpoint UI`() {
        get("/rest") shouldContain "Swagger UI"
    }

    @Test
    fun `should have a HAL explorer`() {
        get("/data") shouldContain "authors"
        get("/data") shouldContain "books"
    }

    @Test
    fun `should have a GraphiQL explorer`() {
        // TODO: Sad, but true: GraphiQL is pure JavaScript
        get("/graphiql") shouldContain "document.getElementById('graphiql')"
    }

    @Test
    fun `should have an author through data HATEOAS`() {
        val expected = Author(
            // TODO: Is there a nicer way to do this?
            id = null,
            firstName = "Joanne",
            lastName = "Rowling",
        )

        val json = get("/data/authors/author-1")
        val actual = authorJson.parseObject(json)

        actual shouldBe expected
    }

    @Test
    fun `should find a book by example through data HATEOAS`() {
        // TODO: HAL is throwing away the ID
        val expected = Book(
            // TODO: Is there a nicer way to do this?
            id = null,
            isbn = "978-1-408855-652",
            authorId = "author-1",
            title = "Harry Potter and the Philosopher's Stone",
            pages = 223,
            moby = true,
        )

        val json = get("/data/books/book-1")
        val actual = bookJson.parseObject(json)

        actual shouldBe expected
    }

    @Test
    fun `should have all authors through REST endpoint`() {
        val json = get("/rest/authors")
        val actual = authorsJson.parseObject(json)

        actual shouldHaveSize 5
    }

    @Test
    fun `should have a limited view of authors through REST endpoint`() {
        val expected = Author(
            id = "author-5",
            firstName = "John",
            lastName = "Tolkien",
        )
        val json = get("/rest/authors?sort=lastName,desc&size=1")
        val actual = authorsJson.parseObject(json)

        actual shouldBe listOf(expected)
    }

    @Test
    fun `should have an author through REST endpoint`() {
        val expected = Author(
            id = "author-1",
            firstName = "Joanne",
            lastName = "Rowling",
        )

        val json = get("/rest/authors/author-1")
        val actual = authorJson.parseObject(json)

        actual shouldBe expected
    }

    @Test
    fun `should have all books through REST endpoint`() {
        val json = get("/rest/books")
        val actual = booksJson.parseObject(json)

        actual shouldHaveSize 5
    }

    @Test
    fun `should have a limited view of books through REST endpoint`() {
        val expected = Book(
            id = "book-4",
            isbn = "978-1-250254-498",
            authorId = "author-4",
            title = "Three-Body Problem",
            pages = 1515,
            moby = true,
        )
        val json = get("/rest/books?sort=pages,desc&size=1")
        val actual = booksJson.parseObject(json)

        actual shouldBe listOf(expected)
    }

    @Test
    fun `should have a book through REST endpoint`() {
        val expected = Book(
            id = "book-1",
            isbn = "978-1-408855-652",
            authorId = "author-1",
            title = "Harry Potter and the Philosopher's Stone",
            pages = 223,
            moby = true,
        )

        val json = get("/rest/books/book-1")
        val actual = bookJson.parseObject(json)

        actual shouldBe expected
    }

    @Test
    fun `should have an info endpoint`() {
        get("/admin/info") shouldContain "java"
    }

    private fun get(path: String) = HttpClient.newBuilder()
        .followRedirects(ALWAYS)
        .build()
        .send(
            HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:$port$path"))
                .build(),
            ofString()
        )
        .body()
}
