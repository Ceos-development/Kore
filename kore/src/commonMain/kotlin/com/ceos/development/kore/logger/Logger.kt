package com.ceos.development.kore.logger

import kotlin.properties.Delegates

interface Logger {
    fun d(tag: String, msg: String? = null, tr: Throwable? = null)
    fun e(tag: String, msg: String? = null, tr: Throwable? = null)
    fun i(tag: String, msg: String? = null, tr: Throwable? = null)
    fun v(tag: String, msg: String? = null, tr: Throwable? = null)
    fun w(tag: String, msg: String? = null, tr: Throwable? = null)

    companion object {
        private var instance: Logger by Delegates.notNull<Logger>()

        fun init(logger: Logger){
            instance = logger
        }

        fun d(tag: String, msg: String? = null, tr: Throwable? = null) = instance.d(
            tag, msg, tr
        )

        fun e(tag: String, msg: String? = null, tr: Throwable? = null) = instance.e(
            tag, msg, tr
        )

        fun i(tag: String, msg: String? = null, tr: Throwable? = null) = instance.i(
            tag, msg, tr
        )

        fun v(tag: String, msg: String? = null, tr: Throwable? = null) = instance.v(
            tag, msg, tr
        )

        fun w(tag: String, msg: String? = null, tr: Throwable? = null) = instance.w(
            tag, msg, tr
        )
    }
}