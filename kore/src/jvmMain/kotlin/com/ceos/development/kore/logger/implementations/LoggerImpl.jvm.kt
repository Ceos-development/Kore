package com.ceos.development.kore.logger.implementations

import com.ceos.development.kore.logger.Logger
import com.ceos.development.kore.logger.models.Log
import com.ceos.development.kore.logger.models.LogPriority
import java.io.PrintWriter
import java.io.StringWriter
import java.time.LocalDateTime

actual class LoggerImpl(
    private val doOnLog: (Log) -> Unit
) : Logger {
    actual override fun d(tag: String, msg: String?, tr: Throwable?) {
        log(priority = LogPriority.DEBUG, tag = tag, message = msg, throwable = tr)
    }

    actual override fun e(tag: String, msg: String?, tr: Throwable?) {
        log(priority = LogPriority.ERROR, tag = tag, message = msg, throwable = tr)
    }

    actual override fun i(tag: String, msg: String?, tr: Throwable?) {
        log(priority = LogPriority.INFO, tag = tag, message = msg, throwable = tr)
    }

    actual override fun v(tag: String, msg: String?, tr: Throwable?) {
        log(priority = LogPriority.VERBOSE, tag = tag, message = msg, throwable = tr)
    }

    actual override fun w(tag: String, msg: String?, tr: Throwable?) {
        log(priority = LogPriority.WARN, tag = tag, message = msg, throwable = tr)
    }

    private fun log(priority: LogPriority, tag: String, message: String?, throwable: Throwable?) {
        val log = Log(priority, tag, message, throwable)
        doOnLog(log)
        printLog(log)
    }

    private fun printLog(log: Log) {
        val color = log.color()
        println("$color${formatMessage(log)}\u001B[0m")

    }

    private fun formatMessage(log: Log): String {
        val timestamp = LocalDateTime.now().toString()
        val typePrefix = log.priority.name

        return "$timestamp [$typePrefix] ${log.tag}: ${log.message.orEmpty()} ${
            getStackTraceString(
                log.throwable
            )
        }"
    }

    private fun Log.color(): String = when (priority) {
        LogPriority.DEBUG -> "\u001B[34m" //BLUE
        LogPriority.ERROR -> "\u001B[31m" //RED
        LogPriority.INFO,
        LogPriority.VERBOSE -> "\u001B[37m" //WHITE
        LogPriority.WARN -> "\u001B[33m" //YELLOW
    }

    private fun getStackTraceString(t: Throwable?): String {
        if (t == null)
            return ""
        // Don't replace this with Log.getStackTraceString() - it hides
        // UnknownHostException, which is not what we want.
        val sw = StringWriter(256)
        val pw = PrintWriter(sw, false)
        t.printStackTrace(pw)
        pw.flush()
        return sw.toString()
    }
}