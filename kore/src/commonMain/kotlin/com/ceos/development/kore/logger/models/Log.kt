package com.ceos.development.kore.logger.models

data class Log(
   val priority: LogPriority,
   val tag: String,
   val message: String?,
   val throwable: Throwable?
)
