package com.hendisantika.books.form

import com.hendisantika.books.domain.AuthorityRole
import com.hendisantika.books.domain.AuthorityUser
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

/**
 * Created by hendisantika on 24/01/17.
 */
class SignUpForm() {
    @NotNull
//    lateinit
    var loginId: String = ""

    @NotNull
    @Size(min = 6)
//    lateinit
    var password: String = ""

    @NotNull
    @Size(min = 6)
//    private lateinit
    var againPassword: String = ""

    private val encoder = BCryptPasswordEncoder()

    constructor(loginId: String, password: String, againPassword: String): this(){
        this.loginId = loginId
        this.password = password
        this.againPassword = againPassword
    }

    fun toAuthorityUser(): AuthorityUser {
        return AuthorityUser(loginId = loginId, password = encoder.encode(password), enabled = 1, roles = mutableListOf(AuthorityRole(1, "USER")))
    }
}
