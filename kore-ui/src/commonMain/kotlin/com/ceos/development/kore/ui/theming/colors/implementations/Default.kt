package com.ceos.development.kore.ui.theming.colors.implementations

import androidx.compose.ui.graphics.Color
import com.ceos.development.kore.ui.theming.colors.Colors

data class Default(
    override val primary: Color = ColorTokens.Primary40,
    override val onPrimary: Color = ColorTokens.Primary100,
    override val secondary: Color = ColorTokens.Secondary40,
    override val onSecondary: Color = ColorTokens.Secondary100,
    override val background: Color = ColorTokens.Neutral99,
    override val onBackground: Color = ColorTokens.Neutral10,
    override val lowestEmphasisSurface: Color = ColorTokens.Neutral100,
    override val lowEmphasisSurface: Color = ColorTokens.Neutral96,
    override val surface: Color = ColorTokens.Neutral99,
    override val onSurface: Color = ColorTokens.Neutral10,
    override val onSurfaceSubtle: Color = ColorTokens.Neutral20,
    override val highEmphasisSurface: Color = ColorTokens.Neutral92,
    override val highestEmphasisSurface: Color = ColorTokens.Neutral90,
    override val outline: Color = ColorTokens.NeutralVariant50,
) : Colors
