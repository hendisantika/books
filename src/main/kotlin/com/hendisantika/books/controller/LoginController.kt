package com.hendisantika.books.controller

import com.hendisantika.books.form.SignUpForm
import com.hendisantika.books.repository.AuthorityUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

/**
 * Created by hendisantika on 24/01/17.
 */

@Controller
class LoginController {
    @Autowired
    lateinit var authorityUserRepository: AuthorityUserRepository

    @RequestMapping("/login")
    fun loginPage(): ModelAndView {
        return ModelAndView("/login")
    }

    @RequestMapping("/signUp", method = arrayOf(RequestMethod.POST))
    fun signUp(@ModelAttribute @Validated signUpForm: SignUpForm, result: BindingResult, model: ModelAndView): ModelAndView {
        if(result.hasErrors()) return model.apply { viewName = "/login?error" }

        authorityUserRepository.save(signUpForm.toAuthorityUser())

        return model.apply { viewName = "forward:loginProc?loginId=${signUpForm.loginId}&password=${signUpForm.password}" }
    }
}