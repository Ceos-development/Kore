package com.ceos.development.kore.logger.implementations

import android.util.Log
import com.ceos.development.kore.logger.Logger

actual class LoggerImpl() : Logger {
    actual override fun d(tag: String, msg: String?, tr: Throwable?) {
        Log.d(tag, msg, tr)
    }

    actual override fun e(tag: String, msg: String?, tr: Throwable?) {
        Log.e(tag, msg, tr)
    }

    actual override fun i(tag: String, msg: String?, tr: Throwable?) {
        Log.i(tag, msg, tr)
    }

    actual override fun v(tag: String, msg: String?, tr: Throwable?) {
        Log.v(tag, msg, tr)
    }

    actual override fun w(tag: String, msg: String?, tr: Throwable?) {
        Log.w(tag, msg, tr)
    }
}