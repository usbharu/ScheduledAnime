package usbharu.github.io


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import usbharu.github.io.niconico.model.*
import usbharu.github.io.plugins.*
import usbharu.github.io.util.ProcessRunner
import java.io.File

suspend fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureTemplating()
        configureMonitoring()
        configureRouting()
        configureSerialization()
    }.start(wait = false)

//    var client = HttpClient(CIO)
//    var response =
//        client.get("https://public.api.nicovideo.jp/v2/wakutkool/frames.json?names=nanime-ranking-daily&names=nanime-header-period&names=nanime-top-maintenance&names=nanime-period-notice&names=nanime-period-news&responseType=pc") {
//            headers {
//                append(HttpHeaders.Accept, "*/*")
//                append("X-Frontend-Id", "122")
//            }
//        }
//    var receive = response.bodyAsText()
//    println(receive)

//    val receive = File("K:\\Documents\\GitHub\\ScheduledAnime\\src\\main\\resources\\test.json").readText()
//
//
//    var objectMapper = jacksonObjectMapper()
//    objectMapper.registerModule(JavaTimeModule())
//    var readValue = objectMapper.readValue<AnimeListResponse>(receive)
//    for (frame in readValue.data.frames) {
//        for (item in frame.items) {
//            if (item is DailyRankingItem) {
//                for (video in item.values.channelVideos.videos) {
//                    println(video.title)
//                }
//            }
//            else if (item is PeriodHeaderItem) break
//            else if (item is TopMaintenance) break
//        }
//    }

    ProcessRunner.run("C:\\Users\\haruj\\Desktop\\yt-dl\\yt-dlp.exe","--version")
}

private fun Application.configureSerialization() {
    install(ContentNegotiation){
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT,true)
            registerModule(JavaTimeModule())
        }
    }
}
