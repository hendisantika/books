package com.hendisantika.books.controller

import com.hendisantika.books.service.AuthorityUserService
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
@RequestMapping("/users")
class UsersController @Autowired constructor(private val userService: AuthorityUserService) {

    @GetMapping
    fun users(@PageableDefault(size = 20) page: Pageable, model: ModelAndView): ModelAndView {
        return model.apply { viewName = "/users"
            addObject("page", userService.findAll(page)) }
    }
}