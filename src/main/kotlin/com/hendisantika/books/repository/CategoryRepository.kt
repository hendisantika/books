package com.hendisantika.books.repository

import com.hendisantika.books.domain.Category

/**
 * Created by hendisantika on 24/01/17.
 */

@Repository
interface CategoryRepository : JpaRepository<Category, Long>