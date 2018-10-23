package com.hendisantika.books.controller

import com.hendisantika.books.service.AuthorityUserService

/**
 * Created by hendisantika on 24/01/17.
 */

@Controller
@RequestMapping("/users")
class UsersController @Autowired constructor(private val userService: AuthorityUserService) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun users(@PageableDefault(size = 20) page: Pageable, model: ModelAndView): ModelAndView {
        return model.apply { viewName = "/users"
            addObject("page", userService.findAll(page)) }
    }
}