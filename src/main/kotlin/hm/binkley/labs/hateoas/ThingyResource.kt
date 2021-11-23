package hm.binkley.labs.hateoas

import org.springframework.web.bind.annotation.RestController

@RestController
class ThingyResource(db: ThingyRepository)
