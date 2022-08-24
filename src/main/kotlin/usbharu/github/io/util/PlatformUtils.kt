package usbharu.github.io.util

import java.util.*

object PlatformUtils {
    val OS_NAME = System.getProperty("os.name").lowercase(Locale.getDefault())

    fun isLinux():Boolean{
        return OS_NAME.startsWith("linux")
    }

    fun isWindows():Boolean{
        return OS_NAME.startsWith("windows")
    }
}
