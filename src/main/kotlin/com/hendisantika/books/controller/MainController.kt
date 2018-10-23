package com.hendisantika.books.controller

import com.hendisantika.books.service.BookService

/**
 * Created by hendisantika on 24/01/17.
 */

@Controller
@RequestMapping("/main")
class MainController  @Autowired constructor(private val bookService: BookService) {
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun main(@PageableDefault(size = 5) pageable: Pageable): ModelAndView {
        return ModelAndView("/main").apply { addObject("page", bookService.findPageBooks(pageable)) }
    }
}