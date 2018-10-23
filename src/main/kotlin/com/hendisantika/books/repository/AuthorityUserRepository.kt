package com.hendisantika.books.repository

import com.hendisantika.books.domain.AuthorityUser

/**
 * Created by hendisantika on 24/01/17.
 */

@Repository
interface AuthorityUserRepository : JpaRepository<AuthorityUser, Long> {
    fun findByLoginId(loginid: String): AuthorityUser?
}