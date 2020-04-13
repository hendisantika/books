package com.hendisantika.books.service

import com.hendisantika.books.domain.Book
import com.hendisantika.books.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Created by hendisantika on 24/01/17.
 */

@Service
class BookService @Autowired constructor(private val bookRepository: BookRepository)  {

    fun findAllBook(): MutableList<Book> = bookRepository.findAll()

    fun findPageBooks(pageable: Pageable): Page<Book> = bookRepository.findAll(pageable)
}