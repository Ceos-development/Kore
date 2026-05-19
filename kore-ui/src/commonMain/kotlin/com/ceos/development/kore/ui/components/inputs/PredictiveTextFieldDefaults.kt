package com.ceos.development.kore.ui.components.inputs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.ceos.development.kore.ui.theming.colors.Colors

object PredictiveTextFieldDefaults {

    @Composable
    fun colors(
        border: Color = Colors.current.outline,
        container: Color = Colors.current.highestEmphasisSurface,
        content: Color = Colors.current.onSurface,
        cursor: Color = Colors.current.primary,
    ): PredictiveTextFieldColors = PredictiveTextFieldColors(
        border = border,
        container = container,
        content = content,
        cursor = cursor,
    )

    @Immutable
    data class PredictiveTextFieldColors(
        val border: Color,
        val container: Color,
        val content: Color,
        val cursor: Color,

        )
}