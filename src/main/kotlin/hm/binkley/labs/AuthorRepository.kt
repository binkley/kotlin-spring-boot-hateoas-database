package hm.binkley.labs

import org.springframework.data.repository.PagingAndSortingRepository

@Suppress("unused")
interface AuthorRepository : PagingAndSortingRepository<Author, String>
