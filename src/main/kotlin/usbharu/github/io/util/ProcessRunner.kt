package usbharu.github.io.util

import java.io.BufferedReader
import java.io.InputStreamReader

object ProcessRunner {

    fun run(command: String, vararg args: String): Int {
        val processBuilder = ProcessBuilder(command, *args)
        processBuilder.redirectErrorStream(true)

        val process = processBuilder.start()

        val inputStream = process.inputStream

        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        println(bufferedReader.readText())
        val waitFor = process.waitFor()
        bufferedReader.close()
        return waitFor


    }

}
