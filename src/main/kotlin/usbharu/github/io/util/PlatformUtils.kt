package usbharu.github.io.util

import java.util.*
/**
プラットフォームに関するユーティリティークラス
*/
object PlatformUtils {
    val OS_NAME = System.getProperty("os.name").lowercase(Locale.getDefault())

    /**
        現在のプラットフォームがlinuxならtrueを返す。
    */

    fun isLinux():Boolean{
        return OS_NAME.startsWith("linux")
    }

    /**
        現在のプラットフォームがwindowsならtrueを返す。
    */
    fun isWindows():Boolean{
        return OS_NAME.startsWith("windows")
    }
}
