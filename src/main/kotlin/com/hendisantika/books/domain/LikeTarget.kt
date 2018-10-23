package com.hendisantika.books.domain

import javax.persistence.Column

/**
 * Created by hendisantika on 24/01/17.
 */

abstract class LikeTarget {
    @Column(nullable = false)
    var likeCount: Int = 0
        private set // testing hendi

    fun likeUp(): Int = likeCount++

    fun likeDown(): Int = if(likeCount === 0){ 0 } else { likeCount-- }
}