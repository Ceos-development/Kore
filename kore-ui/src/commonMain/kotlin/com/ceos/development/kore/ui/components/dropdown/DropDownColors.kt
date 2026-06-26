package com.ceos.development.kore.ui.components.dropdown

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.ceos.development.kore.ui.theming.colors.implementations.Default

data class DropDownColors(
    val content: Color,
    val container: Color,
    val border: Color,
)

val LocalDropDownColors = staticCompositionLocalOf {
    val colors = Default()
    DropDownColors(
        content = colors.onSurface,
        container = colors.highestEmphasisSurface,
        border = colors.outline
    )
}
