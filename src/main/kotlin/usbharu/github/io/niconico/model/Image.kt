package usbharu.github.io.niconico.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Image(val alt:String,val height:Int,val width:Int,val valueType:String,val url:String)
