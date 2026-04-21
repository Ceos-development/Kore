package com.ceos.development.kore.ui.theming.colors.implementations

import androidx.compose.ui.graphics.Color
import com.ceos.development.kore.ui.theming.colors.Colors

data class Default(
    override val primary: Color = ColorTokens.Primary40,
    override val onPrimary: Color = ColorTokens.Primary100,
    override val background: Color = ColorTokens.Neutral99,
    override val onBackground: Color = ColorTokens.Neutral10,
    override val surface: Color = ColorTokens.Neutral99,
    override val onSurface: Color = ColorTokens.Neutral10
) : Colors
