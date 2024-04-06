package com.hendisantika.books.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by IntelliJ IDEA.
 * Project : books
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/6/24
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
@Configuration
class SwaggerConfig {
    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI().info(
            Info()
                .title("Demo project for Spring Boot Books")
                .description("Demo project for Spring Boot Books")
                .version("v0.0.1")
                .contact(getContactDetails())
        )
    }

    private fun getContactDetails(): Contact {
        return Contact()
            .name("Hendi Santika")
            .email("hendisantika@yahoo.co.id")
            .url("https://s.id/hendisantika")
    }
}
