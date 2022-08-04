package hm.binkley.labs

import org.springframework.data.repository.PagingAndSortingRepository

interface AuthorRepository : PagingAndSortingRepository<Author, String>
