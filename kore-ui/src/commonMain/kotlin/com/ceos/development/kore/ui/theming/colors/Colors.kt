package com.ceos.development.kore.ui.theming.colors

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.ceos.development.kore.ui.theming.colors.implementations.ColorTokens
import com.ceos.development.kore.ui.theming.colors.implementations.DarkThemeColors
import com.ceos.development.kore.ui.theming.colors.implementations.Default

interface Colors {
    val primary: Color
    val onPrimary: Color
    val background: Color
    val onBackground: Color
    val surface: Color
    val onSurface: Color

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
            background: Color = ColorTokens.Neutral99,
            onBackground: Color = ColorTokens.Neutral10,
            surface: Color = ColorTokens.Neutral99,
            onSurface: Color = ColorTokens.Neutral10
        ): Colors = Default(primary, onPrimary, background, onBackground, surface, onSurface)


        val current: Colors
            @Composable
            @ReadOnlyComposable
            get() = if (isSystemInDarkTheme()) _colors.first else _colors.second
    }
}