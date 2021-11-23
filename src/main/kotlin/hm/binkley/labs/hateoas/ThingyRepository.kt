package hm.binkley.labs.hateoas

import org.springframework.data.repository.PagingAndSortingRepository

interface ThingyRepository : PagingAndSortingRepository<Thingy, String>
