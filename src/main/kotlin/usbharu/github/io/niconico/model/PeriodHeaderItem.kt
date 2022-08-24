package usbharu.github.io.niconico.model

data class PeriodHeaderItem(val itemId:Int, override val name:String?, val isNew:Boolean, val values: HeaderValue?):AbstractRanking(name)
