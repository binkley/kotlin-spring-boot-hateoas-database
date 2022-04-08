package hm.binkley.labs.hateoas

import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/rest/thingies")
@RestController
class ThingyController(
    private val thingies: ThingyRepository,
) {
    @GetMapping("")
    fun all() = thingies.findAll()

    @GetMapping("{id}")
    fun byId(@PathVariable id: Long) = thingies.findById(id)
        .orElseThrow { ResourceNotFoundException() }
}
