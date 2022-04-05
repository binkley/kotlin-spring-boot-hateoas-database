package hm.binkley.labs.hateoas

import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.json.JacksonTester
import org.springframework.boot.web.server.LocalServerPort
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpClient.Redirect.ALWAYS
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers.ofString

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureJsonTesters
class HateoasApplicationIT(
    @LocalServerPort private val port: Int,
    @Autowired val thingyJson: JacksonTester<Thingy>,
) {
    @Test
    fun `should have a thingy`() {
        // TODO: Why doesn't test populate the `id` field?
        val expected = Thingy("Frodo lives!", true)

        val json = get("/data/thingies/1").body()
        val actual = thingyJson.parseObject(json)

        actual shouldBe expected
    }

    @Test
    fun `should have an info endpoint`() {
        get("/admin/info").body() shouldContain
            "kotlin-spring-boot-hateoas-database"
    }

    @Test
    fun `should have a HAL explorer`() {
        get("/data").body() shouldContain "thingies"
    }

    @Test
    fun `should have an endpoint UI`() {
        get("/").body() shouldContain "Swagger UI"
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
}
