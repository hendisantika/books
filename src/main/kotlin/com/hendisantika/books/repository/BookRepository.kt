package com.hendisantika.books.repository

import com.hendisantika.books.domain.Book

/**
 * Created by hendisantika on 24/01/17.
 */

@Repository
interface BookRepository : JpaRepository<Book, Long>