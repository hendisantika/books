package com.hendisantika.books.service

import com.hendisantika.books.domain.AuthorityUser
import com.hendisantika.books.repository.AuthorityUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Created by hendisantika on 24/01/17.
 */

@Service
class AuthorityUserService @Autowired constructor(private val repository: AuthorityUserRepository) {
    fun findAll(page: Pageable): Page<AuthorityUser> = repository.findAll(page)
}