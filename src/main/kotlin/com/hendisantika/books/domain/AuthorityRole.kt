package com.hendisantika.books.domain

import jakarta.persistence.*

/**
 * Created by hendisantika on 24/01/17.
 */

@Entity
@Table(name = "authority_role")
class AuthorityRole() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
        private set

    @Column
    lateinit var name: String
        private set

    constructor(id: Int? = null, name: String): this(){
        this.id = id
        this.name = name
    }
}
