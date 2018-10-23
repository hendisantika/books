package com.hendisantika.books.config

import com.hendisantika.books.service.AuthorityUserDetailsService

/**
 * Created by hendisantika on 24/01/17.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    private lateinit var userDetailsService: AuthorityUserDetailsService

    override fun configure(http: HttpSecurity?) {
        http?: return

        http.authorizeRequests().antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/image/**").permitAll()
                .antMatchers("/signUp").permitAll()
                .anyRequest().authenticated()

        http.formLogin().loginPage("/login")
                .loginProcessingUrl("/loginProc")
                .defaultSuccessUrl("/main")
                .usernameParameter("loginId")
                .passwordParameter("password")
                .failureUrl("/login?error")
                .permitAll()

        http.logout().logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
    }

    @Autowired
    fun configAuthentication(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(BCryptPasswordEncoder())
    }
}