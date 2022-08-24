package usbharu.github.io.niconico.model

import java.time.ZonedDateTime

data class Anime(
    val commentCounter: Int,
    val id: String,
    val largeThumbnailUrl: String?,
    val lastResBody: String,
    val lengthSeconds: Int,
    val middleThumbnailUrl: String?,
    val mylistCounter: Int,
    val ownerId: Int,
    val ownerIcon:String,
    val ownerType:String,
    val ownerName: String,
    val startTime: ZonedDateTime,
    val thumbnailUrl: String,
    val title: String,
    val url: String,
    val viewCounter: Int
)
