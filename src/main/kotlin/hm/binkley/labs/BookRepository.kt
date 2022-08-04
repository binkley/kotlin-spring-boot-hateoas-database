package hm.binkley.labs

import org.springframework.data.repository.PagingAndSortingRepository

interface BookRepository : PagingAndSortingRepository<Book, String>
