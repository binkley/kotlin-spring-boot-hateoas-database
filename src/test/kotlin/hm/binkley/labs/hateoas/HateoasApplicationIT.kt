package hm.binkley.labs.hateoas

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers.ofString

@SpringBootTest(webEnvironment = RANDOM_PORT)
class HateoasApplicationIT {
    @LocalServerPort
    var port: Int = 0

    val client = HttpClient.newHttpClient()

    @Test
    fun `should have a thingy`() {
        get("/data/thingies/1").body()
    }

    @Test
    fun `should have info endpoint`() {
        get("/admin/info").body()
    }

    private fun get(path: String) = client.send(
        HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("http://localhost:$port$path"))
            .build(),
        ofString()
    )
}
