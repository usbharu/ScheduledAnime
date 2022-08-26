package usbharu.github.io.domain.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.dao.LongIdTable

object AnimesSeries : LongIdTable(name = "AnimeSeries"){
    val seriesTitle = text("series_title").uniqueIndex()
    val seriesUrl = text("series_url").uniqueIndex()
}
