package usbharu.github.io.niconico.model

data class DailyRankingValue(
    val aggregateDate: AggregateDate,
    val channelVideos: ChannelVideos,
    val introduction: AnimeInfo,
    val isChFirstEpisodeFree: AnimeInfo,
    val isChLatestEpisodeFree: AnimeInfo,
    val isDanime: AnimeInfo,
    val isOfficialImageQuote: AnimeInfo,
    val nanimeId: AnimeInfo,
    val officialUrl: AnimeInfo,
    val rank: AnimeInfo,
    val score: AnimeInfo,
    val title: AnimeInfo
)
