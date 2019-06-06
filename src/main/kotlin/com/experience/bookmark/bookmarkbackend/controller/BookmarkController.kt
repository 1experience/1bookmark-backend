package com.experience.bookmark.bookmarkbackend.controller

import com.experience.bookmark.bookmarkbackend.google.GoogleSheetClient
import com.experience.bookmark.bookmarkbackend.model.Bookmark
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController(value = "/bookmarks")
class BookmarkController(
        private val googleSheetClient: GoogleSheetClient
) {

    @GetMapping
    fun getBookmarks(): Flux<Bookmark> {
        return googleSheetClient.getBookmarks()
    }
}