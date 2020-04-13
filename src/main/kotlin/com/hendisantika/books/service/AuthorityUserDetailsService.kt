package com.hendisantika.books.service

import com.hendisantika.books.repository.AuthorityUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Created by hendisantika on 24/01/17.
 */

@Service
class AuthorityUserDetailsService : UserDetailsService {
    @Autowired
    private lateinit var repository: AuthorityUserRepository

    override fun loadUserByUsername(loginId: String?): UserDetails? {
        loginId?: throw UsernameNotFoundException("login id is null")
        return repository.findByLoginId(loginId)?.let { AuthorityUserDetails.create(it) }?: throw UsernameNotFoundException("account not found. login id is $loginId")
    }
}