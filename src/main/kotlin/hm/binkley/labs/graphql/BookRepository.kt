package hm.binkley.labs.graphql

import org.springframework.data.repository.PagingAndSortingRepository

@Suppress("unused")
interface BookRepository : PagingAndSortingRepository<Book, String>
