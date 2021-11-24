package hm.binkley.labs.hateoas

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.json.JacksonTester
import org.springframework.boot.web.server.LocalServerPort
import java.net.URI
import java.net.http.HttpClient
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

        assert(expected == actual) {
            "Wrong thingy: expected: $expected; got $actual"
        }
    }

    @Test
    fun `should have info endpoint`() {
        get("/admin/info").body()
    }

    private fun get(path: String) = HttpClient.newHttpClient().send(
        HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("http://localhost:$port$path"))
            .build(),
        ofString()
    )
}
