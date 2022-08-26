package usbharu.github.io.domain.model.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import usbharu.github.io.domain.model.Animes
import usbharu.github.io.domain.model.AnimesSeries

class AnimeSeries(id: EntityID<Long>): LongEntity(id){
    companion object : LongEntityClass<AnimeSeries>(AnimesSeries)

    var seriesTitle by AnimesSeries.seriesTitle
    var seriesUrl by AnimesSeries.seriesUrl
    val series by Anime referrersOn Animes.seriesId
}
