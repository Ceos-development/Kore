package com.ceos.development.kore.ui.components.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.ceos.development.kore.ui.theming.colors.Colors

object SearchBarDefaults {
    @Composable
    fun colors() = Colors.current.defaultSearchBarColors

    private val Colors.defaultSearchBarColors: SearchBarColors
    @Composable
    get() = SearchBarColors(
        backgroundColor = surface,
        contentColor = onSurface,
    )

    @Immutable
    data class SearchBarColors(
        val backgroundColor: Color,
        val contentColor: Color,
    )
}