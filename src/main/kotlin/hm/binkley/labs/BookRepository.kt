package hm.binkley.labs

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface BookRepository :
    CrudRepository<Book, String>, PagingAndSortingRepository<Book, String>
