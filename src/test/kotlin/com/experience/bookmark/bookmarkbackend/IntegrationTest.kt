package com.experience.bookmark.bookmarkbackend

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(value = [SpringExtension::class])
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [Application::class]
)
abstract class IntegrationTest {
    @LocalServerPort
    var applicationPort: Int = 0

    @BeforeEach
    fun initializeRestAssured() {
        RestAssured.port = applicationPort
    }
}