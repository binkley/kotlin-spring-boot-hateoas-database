package hm.binkley.labs.hateoas

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ThingyController(
    private val thingies: ThingyRepository,
) {
    @GetMapping("/rest/thingies")
    fun firstThingy(): Iterable<Thingy> = thingies.findAll()
}
