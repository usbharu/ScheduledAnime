package usbharu.github.io.niconico.model

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "name"
)
@JsonSubTypes(
    JsonSubTypes.Type(value = DailyRankingItem::class, name = "nanime-ranking-daily"),
    JsonSubTypes.Type(value = PeriodHeaderItem::class, name = "nanime-header-period"),
    JsonSubTypes.Type(value = TopMaintenance::class,name = "nanime-top-maintenance"),
    JsonSubTypes.Type(value = TopMaintenance::class,name = "nanime-period-notice"),
    JsonSubTypes.Type(value = TopMaintenance::class,name = "nanime-period-news")
)
sealed class AbstractRanking(open val name: String?)
