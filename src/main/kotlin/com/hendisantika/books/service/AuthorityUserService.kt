package com.hendisantika.books.service

import com.hendisantika.books.domain.AuthorityUser
import com.hendisantika.books.repository.AuthorityUserRepository

/**
 * Created by hendisantika on 24/01/17.
 */

@Service
class AuthorityUserService @Autowired constructor(private val repository: AuthorityUserRepository) {
    fun findAll(page: Pageable): Page<AuthorityUser> = repository.findAll(page)
}