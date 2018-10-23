package com.hendisantika.books.service

import com.hendisantika.books.domain.Book
import com.hendisantika.books.repository.BookRepository

/**
 * Created by hendisantika on 24/01/17.
 */

@Service
class BookService @Autowired constructor(private val bookRepository: BookRepository)  {

    fun findAllBook(): MutableList<Book> = bookRepository.findAll()

    fun findPageBooks(pageable: Pageable): Page<Book> = bookRepository.findAll(pageable)
}