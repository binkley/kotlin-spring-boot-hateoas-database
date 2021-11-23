package hm.binkley.labs.hateoas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HateoasApplication

fun main(args: Array<String>) {
    runApplication<HateoasApplication>(*args)
}
