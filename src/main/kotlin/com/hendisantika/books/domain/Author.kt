package com.hendisantika.books.domain

import jakarta.persistence.*

/**
 * Created by hendisantika on 24/01/17.
 */

@Entity
@Table(name = "author")
class Author () : LikeTarget() {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    lateinit var name: String

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = arrayOf(JoinColumn(name = "author_id")), inverseJoinColumns = arrayOf(JoinColumn(name = "book_id")))
    lateinit var books: MutableList<Book>


    constructor(id: Long? = null, name: String, likeCount: Int = 0, books: MutableList<Book> = mutableListOf()): this(){
        this.id = id
        this.name = name
        this.likeCount = likeCount
        this.books = books
    }

}
