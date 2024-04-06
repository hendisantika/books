package com.hendisantika.books.config

import com.hendisantika.books.service.AuthorityUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

/**
 * Created by hendisantika on 24/01/17.
 */

@Configuration
@EnableWebSecurity
//@EnableGlobalSecurity(prePostEnabled = true, securedEnabled = true)
class WebSecurityConfig {
    @Autowired
    private lateinit var userDetailsService: AuthorityUserDetailsService

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            // you can either disable this or
            // put <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            // inside the login form
            .csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { authz ->
                authz
                    .requestMatchers("/css/**", "/img/**", "/js**", "/signUp").permitAll()
                    .anyRequest().authenticated()
            }
            .formLogin { formLogin ->
                formLogin
                    .loginPage("/login") // enable this to go to your own custom login page
                    .loginProcessingUrl("/loginProc") // enable this to use login page provided by spring security
                    .usernameParameter("loginId")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/main", true)
                    .failureUrl("/login.html?error=true")
            }
            .logout { logout ->
                logout
                    .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .permitAll()
            }
            .build()
    }


    @Autowired
    fun configAuthentication(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(BCryptPasswordEncoder())
    }
}
