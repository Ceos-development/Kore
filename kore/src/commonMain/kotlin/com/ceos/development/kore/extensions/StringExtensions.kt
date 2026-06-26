package com.ceos.development.kore.extensions

fun String.toSnakeCase(): String = this.let {
    val regex = "(?<=[a-z])(?=[A-Z])".toRegex()
    return regex.replace(this) { "_" }.lowercase()
}