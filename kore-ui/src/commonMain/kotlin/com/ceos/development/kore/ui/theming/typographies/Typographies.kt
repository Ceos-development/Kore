package com.ceos.development.kore.ui.theming.typographies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import com.ceos.development.kore.ui.theming.typographies.implementations.Default

interface Typographies {
    val title: TextStyle
    val subtitle: TextStyle
    val body: TextStyle
    val label: TextStyle
    val button: TextStyle

    companion object {
        private var typographies by mutableStateOf<Typographies>(Default())

        internal fun setTypographies(typographies: Typographies) {
            Companion.typographies = typographies
        }

        val current: Typographies
            get() = typographies

    }
}