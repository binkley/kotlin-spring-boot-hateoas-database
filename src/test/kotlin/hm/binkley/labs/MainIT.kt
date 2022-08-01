package hm.binkley.labs

import hm.binkley.labs.hateoas.Thingy
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
class MainIT(
    @LocalServerPort private val port: Int,
    @Autowired private val thingyJson: JacksonTester<Thingy>,
) {
    @Test
    fun `should have an endpoint UI`() {
        get("/rest") shouldContain "Swagger UI"
    }

    @Test
    fun `should have a HAL explorer`() {
        get("/data") shouldContain "thingies"
    }

    @Test
    fun `should have a thingy through data HATEOAS`() {
        // TODO: HAL is throwing away the ID
        val expected = Thingy(
            id = null,
            text = "Frodo lives!",
            moby = true,
        )

        val json = get("/data/thingies/1")
        val actual = thingyJson.parseObject(json)

        actual shouldBe expected
    }

    @Test
    fun `should have a thingy through REST endpoint`() {
        val expected = Thingy(
            id = 1L,
            text = "Frodo lives!",
            moby = true,
        )

        val json = get("/rest/thingies/1")
        val actual = thingyJson.parseObject(json)

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
