package hm.binkley.labs.graphql

import org.springframework.data.repository.PagingAndSortingRepository

@Suppress("unused")
interface AuthorRepository : PagingAndSortingRepository<Author, String>
