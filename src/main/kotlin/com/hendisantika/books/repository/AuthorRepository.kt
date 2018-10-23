package com.hendisantika.books.repository

import com.hendisantika.books.domain.Author

/**
 * Created by hendisantika on 24/01/17.
 */

@Repository
interface AuthorRepository : JpaRepository<Author, Long>