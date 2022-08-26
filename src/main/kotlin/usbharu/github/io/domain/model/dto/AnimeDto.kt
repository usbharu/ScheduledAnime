package usbharu.github.io.domain.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class AnimeDto(val seriesTitle:String,val seriesUrl:String,val title:String, val videoUrl:String, val thumbnailUrl:String)
