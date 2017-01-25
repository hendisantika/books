package com.hendisantika.books.domain

import javax.persistence.*

/**
 * Created by hendisantika on 24/01/17.
 */

@Entity
@Table(name = "category")
class Category() : LikeTarget() {
    @Id
    @GeneratedValue
    var id: Long? = null
    private set


            @Column(nullable = false)
            lateinit var name: String
    private set

            @ManyToMany
            @JoinTable(name = "category_book", joinColumns = arrayOf(JoinColumn(name = "category_id")), inverseJoinColumns = arrayOf(JoinColumn(name = "book_id")))
            lateinit var books: MutableList<Book>



    constructor(id: Long? = null, name: String, likeCount: Int, books: MutableList<Book>): this(){
        this.id = id
        this.name = name
        this.likeCount = likeCount
        this.books = books
    }



}