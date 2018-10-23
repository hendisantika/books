package com.hendisantika.books.domain

import javax.persistence.*

/**
 * Created by hendisantika on 24/01/17.
 */

@Entity
@Table(name = "book")
class Book() : LikeTarget() {
    @Id
    @GeneratedValue
    var id: Long? = null
        private set

    @Column(nullable = false)
    lateinit var title: String
        private set

    @Column
    var subTitle: String? = null
        private set

    @Column(nullable = false)
    lateinit var leadingSentence: String
        private set

    @Column(nullable = false)
    lateinit var imagePath: String
        private set

    @Column(nullable = false)
    lateinit var url: String
        private set


    @ManyToMany(mappedBy = "books")
    lateinit var authors: MutableList<Author>
        private set


    @ManyToMany(mappedBy = "books")
    lateinit var categories: MutableList<Category>
        private set

    @ManyToOne
    @JoinTable(name = "publisher_book", joinColumns = arrayOf(JoinColumn(name = "book_id")), inverseJoinColumns = arrayOf(JoinColumn(name = "publisher_id")))
    lateinit var publisher: Publisher

    constructor(id: Long? = null,
                title: String,
                subTitle: String? = null,
                leadingSentence: String,
                imagePath: String,
                url: String,
                likeCount: Int = 0,
                authors: MutableList<Author> = mutableListOf(),
                categories: MutableList<Category> = mutableListOf(),
                publisher: Publisher = Publisher()) : this() {
        this.id = id
        this.title = title
        this.subTitle = subTitle
        this.leadingSentence = leadingSentence
        this.imagePath = imagePath
        this.url = url
        this.likeCount = likeCount
        this.authors = authors
        this.categories = categories
        this.publisher = publisher
    }
}