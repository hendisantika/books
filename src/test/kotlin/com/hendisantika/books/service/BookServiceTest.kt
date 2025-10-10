package com.hendisantika.books.service

//import org.junit.Assert.assertThat
import com.hendisantika.books.test.TestDataResources
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.annotation.Transactional
import org.hamcrest.CoreMatchers.`is` as be

/**
 * Created by hendisantika on 24/01/17.
 */

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