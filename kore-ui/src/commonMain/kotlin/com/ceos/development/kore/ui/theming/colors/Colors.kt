package com.ceos.development.kore.ui.theming.colors

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.ceos.development.kore.ui.theming.colors.implementations.ColorTokens
import com.ceos.development.kore.ui.theming.colors.implementations.DarkThemeColors
import com.ceos.development.kore.ui.theming.colors.implementations.Default

interface Colors {
    val primary: Color
    val onPrimary: Color
    val primaryDisabled: Color
    val onPrimaryDisabled: Color
    val secondary: Color
    val onSecondary: Color
    val secondaryDisabled: Color
    val onSecondaryDisabled: Color
    val background: Color
    val onBackground: Color
    val lowestEmphasisSurface: Color
    val lowEmphasisSurface: Color
    val surface: Color
    val onSurface: Color
    val onSurfaceSubtle: Color
    val highEmphasisSurface: Color
    val highestEmphasisSurface: Color
    val outline: Color

    companion object {
        private var _colors by mutableStateOf<Pair<Colors, Colors>>(
            Default() to DarkThemeColors()
        )

        internal fun setLightColors(colors: Colors) {
            _colors = colors to _colors.second
        }

        internal fun setDarkColors(colors: Colors) {
            _colors = _colors.first to colors
        }

        internal fun setColors(lightThemeColors: Colors, darkThemeColors: Colors) {
            _colors = lightThemeColors to darkThemeColors
        }

        fun of(
            primary: Color = ColorTokens.Primary40,
            onPrimary: Color = ColorTokens.Primary100,
            secondary: Color = ColorTokens.Secondary40,
            onSecondary: Color = ColorTokens.Secondary100,
            background: Color = ColorTokens.Neutral99,
            onBackground: Color = ColorTokens.Neutral10,
            surface: Color = ColorTokens.Neutral99,
            onSurface: Color = ColorTokens.Neutral10,
            onSurfaceSubtle: Color = ColorTokens.Neutral20,
            outline: Color = ColorTokens.NeutralVariant50,
            textSubtle: Color = ColorTokens.NeutralVariant50,
        ): Colors = Default(
            primary = primary,
            onPrimary = onPrimary,
            secondary = secondary,
            onSecondary = onSecondary,
            background = background,
            onBackground = onBackground,
            lowestEmphasisSurface = surface,
            lowEmphasisSurface = onSurface
        )


        val current: Colors
            @Composable
            @ReadOnlyComposable
            get() = if (isSystemInDarkTheme()) _colors.first else _colors.second

        @Composable
        internal fun reference() {
            MaterialTheme {
            }

        }
    }
}