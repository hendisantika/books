package com.hendisantika.books.repository

import com.hendisantika.books.domain.Publisher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by hendisantika on 24/01/17.
 */

@Repository
interface PublisherRepository : JpaRepository<Publisher, Long>