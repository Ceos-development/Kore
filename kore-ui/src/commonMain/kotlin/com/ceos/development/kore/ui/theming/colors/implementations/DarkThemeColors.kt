package com.ceos.development.kore.ui.theming.colors.implementations

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.ceos.development.kore.ui.theming.colors.Colors

@Immutable
internal class DarkThemeColors : Colors {
    override val primary: Color = ColorTokens.Primary80
    override val onPrimary: Color = ColorTokens.Primary20
    override val primaryDisabled: Color = ColorTokens.Neutral90
    override val onPrimaryDisabled: Color = ColorTokens.NeutralVariant80
    override val secondary: Color = ColorTokens.Secondary80
    override val onSecondary: Color = ColorTokens.Secondary20
    override val secondaryDisabled: Color = ColorTokens.Neutral90
    override val onSecondaryDisabled: Color = ColorTokens.NeutralVariant80
    override val background: Color = ColorTokens.Neutral10
    override val onBackground: Color = ColorTokens.Neutral90
    override val lowestEmphasisSurface: Color = ColorTokens.Neutral4
    override val lowEmphasisSurface: Color = ColorTokens.Neutral10
    override val surface: Color = ColorTokens.Neutral10
    override val onSurface: Color = ColorTokens.Neutral80
    override val onSurfaceSubtle: Color = ColorTokens.Neutral20
    override val highEmphasisSurface: Color = ColorTokens.Neutral17
    override val highestEmphasisSurface: Color = ColorTokens.Neutral22
    override val outline: Color = ColorTokens.NeutralVariant60
}
