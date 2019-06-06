package com.experience.bookmark.bookmarkbackend.controller

import com.experience.bookmark.bookmarkbackend.IntegrationTest
import io.restassured.RestAssured
import org.junit.jupiter.api.Test


class BookmarkControllerIntegrationTest : IntegrationTest() {
    @Test
    fun shouldReturnBookmarks() {
        RestAssured.given()
                .get("/bookmarks")
                .then()
                .statusCode(200)
    }
}