package hm.binkley.labs

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface AuthorRepository :
    CrudRepository<Author, String>, PagingAndSortingRepository<Author, String>
