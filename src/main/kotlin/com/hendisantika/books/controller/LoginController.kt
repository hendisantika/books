package com.hendisantika.books.controller

import com.hendisantika.books.form.SignUpForm
import com.hendisantika.books.repository.AuthorityUserRepository

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