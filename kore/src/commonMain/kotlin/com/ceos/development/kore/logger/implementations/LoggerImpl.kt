package com.ceos.development.kore.logger.implementations

import com.ceos.development.kore.logger.Logger

expect class LoggerImpl: Logger {
    override fun d(tag: String, msg: String?, tr: Throwable?)
    override fun e(tag: String, msg: String?, tr: Throwable?)
    override fun i(tag: String, msg: String?, tr: Throwable?)
    override fun v(tag: String, msg: String?, tr: Throwable?)
    override fun w(tag: String, msg: String?, tr: Throwable?)
}