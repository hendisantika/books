package com.hendisantika.books

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class BooksApplication

fun main(args: Array<String>) {
    SpringApplication.run(BooksApplication::class.java, *args)
}
