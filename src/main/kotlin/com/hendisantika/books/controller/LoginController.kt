package com.hendisantika.books.controller

import com.hendisantika.books.form.SignUpForm
import com.hendisantika.books.repository.AuthorityUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

/**
 * Created by hendisantika on 24/01/17.
 */

@Controller
class LoginController {
    @Autowired
    lateinit var authorityUserRepository: AuthorityUserRepository

    @GetMapping("/login")
    fun loginPage(): ModelAndView {
        return ModelAndView("/login")
    }


    @GetMapping("/signUp")
    fun signUp(model: Model): String {
        model.addAttribute("signUpForm", SignUpForm())
        return "/signup"
    }

    @PostMapping("/signUp")
    fun signUp(@ModelAttribute @Validated signUpForm: SignUpForm, result: BindingResult, model: ModelAndView): ModelAndView {
        if (result.hasErrors()) return model.apply { viewName = "/login?error=true" }

        authorityUserRepository.save(signUpForm.toAuthorityUser())

        return model.apply { viewName = "forward:loginProc?loginId=${signUpForm.loginId}&password=${signUpForm.password}" }
    }
}