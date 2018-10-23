package com.hendisantika.books.domain

import javax.persistence.*

/**
 * Created by hendisantika on 24/01/17.
 */

@Entity
@Table(name = "publisher")
class Publisher() : LikeTarget() {
    @Id
    @GeneratedValue
    var id: Long? = null
        private set

    @Column(nullable = false)
    lateinit var name: String
        private set

    @OneToMany(mappedBy = "publisher")
    lateinit var books: MutableList<Book>

    constructor(id: Long? = null, name: String, likeCount: Int = 0, books: MutableList<Book> = mutableListOf()): this(){
        this.id = id
        this.name = name
        this.likeCount = likeCount
        this.books = books
    }

}