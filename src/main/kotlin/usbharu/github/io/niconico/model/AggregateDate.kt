package usbharu.github.io.niconico.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class AggregateDate(@JsonFormat(pattern = "yyyy年MM月dd日") val context:LocalDate,val valueType:String)
