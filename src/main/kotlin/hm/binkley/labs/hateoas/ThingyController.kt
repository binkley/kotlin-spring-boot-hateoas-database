package hm.binkley.labs.hateoas

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rest/thingies")
@RestController
class ThingyController(
    private val thingies: ThingyRepository,
) {
    @GetMapping("{id}")
    fun firstThingy(@PathVariable id: Long): Thingy =
        thingies.findById(id).get()
}
