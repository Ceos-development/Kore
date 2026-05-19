package com.ceos.development.kore.utlis

import java.util.*

data class LocalizedString(
    val en: String? = null,
    val fr: String? = null
) {

    companion object {
        fun of(value: String): LocalizedString = LocalizedString(
            en = value,
            fr = value
        )

        fun of(vararg languages: Pair<String, String>): LocalizedString =
            of(mapOf(*languages))

        fun of(languages: Map<String, String?>): LocalizedString {
            val languagesEntries = languages.entries
            return LocalizedString(
                en = languagesEntries.firstOrNull { (lang, _) -> lang == "en" || lang == "en-CA" }?.value,
                fr = languagesEntries.firstOrNull { (lang, _) -> lang == "fr" || lang == "fr-CA" }?.value,
            )
        }
    }
}

/**
 * Will return the String value of the local, will fallback if requested is null
 * @param locale The kind of value you want
 * @throws NullPointerException fallback is also null.
 */
fun LocalizedString.toString(locale: Locale): String {
    return if (locale == Locale.FRENCH) {
        this.fr ?: en!!
    } else {
        this.en ?: fr!!
    }
}

fun LocalizedString.toMap(): Map<Locale, String> = buildMap {
    fr?.let { put(Locale.FRENCH, it) }
    en?.let { put(Locale.ENGLISH, it) }
}

/**
 * Will return english, or french (In that order)
 */
val LocalizedString.default: String
    get() = en ?: fr!!


