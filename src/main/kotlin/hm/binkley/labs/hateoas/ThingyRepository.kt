package hm.binkley.labs.hateoas

import org.springframework.data.repository.PagingAndSortingRepository

@Suppress("unused")
interface ThingyRepository : PagingAndSortingRepository<Thingy, String>
