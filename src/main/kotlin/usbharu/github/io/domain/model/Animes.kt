package usbharu.github.io.domain.model

import org.jetbrains.exposed.dao.LongIdTable

object Animes : LongIdTable() {
    val title = text("anime_title")
    val seriesId = reference("series",AnimesSeries)
    val videoUrl = text("video_url")
    val thumbnailUrl = text("thumbnail_url")
    init{
        uniqueIndex(title)
    }
}
