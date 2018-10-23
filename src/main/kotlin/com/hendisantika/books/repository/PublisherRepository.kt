package com.hendisantika.books.repository

import com.hendisantika.books.domain.Publisher

/**
 * Created by hendisantika on 24/01/17.
 */

@Repository
interface PublisherRepository : JpaRepository<Publisher, Long>