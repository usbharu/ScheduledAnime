package usbharu.github.io.domain.model.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import usbharu.github.io.domain.model.Animes
import usbharu.github.io.domain.model.dto.AnimeDto

class Anime(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Anime>(Animes)

    var title by Animes.title
    var seriesId by AnimeSeries referencedOn Animes.seriesId
    var videoUrl by Animes.videoUrl
    var thumbnailUrl by Animes.thumbnailUrl

    fun dto() = AnimeDto(seriesId.seriesTitle,seriesId.seriesUrl, title, videoUrl, thumbnailUrl)
}
