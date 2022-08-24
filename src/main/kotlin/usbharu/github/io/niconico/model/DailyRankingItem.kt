package usbharu.github.io.niconico.model

data class DailyRankingItem(
    val itemId: Int,
    override val name:String?,
    val isNew: String,
    val values: DailyRankingValue
) : AbstractRanking(name)
