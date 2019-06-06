package com.experience.bookmark.bookmarkbackend.controller

import com.experience.bookmark.bookmarkbackend.model.Bookmark
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController(value = "/bookmarks")
class BookmarkController {

    @GetMapping
    fun getBookmarks(): Flux<Bookmark> {
        return Flux.just(
                Bookmark(
                        title = "Facebook",
                        description = "Facebook home page",
                        link = "www.facebook.com"
                )
        )
    }
}