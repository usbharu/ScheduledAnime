package usbharu.github.io.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.thymeleaf.*
import usbharu.github.io.domain.model.dto.AnimeDto

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/season-list"){
            call.respond(ThymeleafContent("season-list", mapOf("videos" to listOf(
                AnimeDto(
                    "リコリス・リコイル",
                    "http:example.com",
                    "リコリス・リコイル 第一話",
                    "http://example.com",
                    "http://file.usbharu-server/%E8%B6%A3%E5%91%B3/%E3%82%A4%E3%83%A9%E3%82%B9%E3%83%88/4/74403591_p0_result_result.jpg"
                )
            ))))
        }
    }
    routing {
        static("/static"){
            resources("static")
        }
    }
}
