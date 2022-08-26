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
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import usbharu.github.io.domain.model.Animes
import usbharu.github.io.domain.model.AnimesSeries
import usbharu.github.io.niconico.model.*
import usbharu.github.io.plugins.*
import usbharu.github.io.util.ProcessRunner
import java.io.File

suspend fun main() {


    Database.connect("jdbc:sqlite:anime.db", driver = "org.sqlite.JDBC")
    transaction {
        SchemaUtils.create(Animes,AnimesSeries)

        var table: EntityID<Long> = AnimesSeries.insertIgnoreAndGetId {
            it[seriesTitle] = "toaru"
            it[seriesUrl] = "http://example.com"
        } ?: return@transaction
        //        usbharu.github.io.domain.model.entity.Anime.new {
//            title = "toaru kagakuno railgun 1"
//            seriesId = new
//            videoUrl = "http://example.com"
//            thumbnailUrl = "http://file.usbharu-server/%E8%B6%A3%E5%91%B3/%E3%82%A4%E3%83%A9%E3%82%B9%E3%83%88/4/74403591_p0_result_result.jpg"
//
//        }
//        usbharu.github.io.domain.model.entity.Anime.new {
//            title = "toaru kagakuno railgun 1"
//            seriesId = new
//            videoUrl = "http://example.com"
//            thumbnailUrl = "http://file.usbharu-server/%E8%B6%A3%E5%91%B3/%E3%82%A4%E3%83%A9%E3%82%B9%E3%83%88/4/74403591_p0_result_result.jpg"
//
//        }
        var resultedValues = Animes.insertIgnore {
            it[title] = "toaru kagakuno railgun"
            it[seriesId] = table
            it[videoUrl] = "http://example.com"
            it[thumbnailUrl] =
                "http://file.usbharu-server/%E8%B6%A3%E5%91%B3/%E3%82%A4%E3%83%A9%E3%82%B9%E3%83%88/4/74403591_p0_result_result.jpg"
        }.resultedValues

        println("return")
        if (resultedValues != null) {
            for ( r in resultedValues){
                println(r)
            }
        }

        println("selectAll")
        for (resultRow in Animes.selectAll()) {
            println(resultRow)
        }
    }

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureTemplating()
        configureMonitoring()
        configureRouting()
        configureSerialization()
    }.start(wait = true)

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
