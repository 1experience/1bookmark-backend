package com.experience.bookmark.bookmarkbackend.google

import com.experience.bookmark.bookmarkbackend.model.Bookmark
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux

@Service
class GoogleSheetClient(
        @Value("\${google.spreadsheet.url}") private val sheetUrl: String) {

    fun getBookmarks(): Flux<Bookmark> {
        return WebClient.builder()
                .build().get()
                .uri(sheetUrl)
                .retrieve()
                .bodyToMono(Response::class.java)
                .toFlux()
                .flatMap { response ->
                    Flux.fromStream {
                        response.values
                                .map { strings ->
                                    val title = strings[0]
                                    val description = strings[1]
                                    val link = strings[2]
                                    Bookmark(title, description, link)
                                }.stream()
                    }
                }
    }
}

data class Response(
        val values: List<List<String>>
)
