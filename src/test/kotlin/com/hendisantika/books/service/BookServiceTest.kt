package com.hendisantika.books.service

import com.hendisantika.books.BooksApplication
import com.hendisantika.books.test.TestDataResources
//import org.junit.Assert.assertThat
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import javax.transaction.Transactional
import org.hamcrest.CoreMatchers.`is` as be
import org.junit.BeforeClass

/**
 * Created by hendisantika on 24/01/17.
 */

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(BooksApplication::class)
@WebAppConfiguration
class BookServiceTest {
    @Rule
    @Autowired
    lateinit var testDataResources: TestDataResources

    @Autowired lateinit var bookService: BookService

    @Test
    @Transactional
    fun findAllBookTest() {
        var sutList = bookService.findAllBook()
        var sut = sutList[0]
        assertThat(sutList.size, be(1))
        assertThat(sut.id, be(1L))
        assertThat(sut.title, be("title"))
        assertThat(sut.subTitle, be("subTitle"))
        assertThat(sut.leadingSentence, be("leading"))
        assertThat(sut.imagePath, be("imagePath"))
        assertThat(sut.url, be("url"))
    }
}