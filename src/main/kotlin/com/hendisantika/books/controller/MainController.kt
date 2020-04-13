package com.hendisantika.books.controller

import com.hendisantika.books.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Created by hendisantika on 24/01/17.
 */

@Controller
@RequestMapping("/main")
class MainController  @Autowired constructor(private val bookService: BookService) {
    @GetMapping
    fun main(@PageableDefault(size = 5) pageable: Pageable): ModelAndView {
        return ModelAndView("/main").apply { addObject("page", bookService.findPageBooks(pageable)) }
    }
}