package com.ceos.development.kore.ui.theming.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.ln

/**
 * Computes the surface tonal color at different elevation levels e.g. surface1 through surface5.
 *
 * @param elevation Elevation value used to compute alpha of the color overlay layer.
 * @return the [ColorScheme.surface] color with an alpha of the [ColorScheme.surfaceTint] color
 *   overlaid on top of it.
 */
@Stable
fun computeColorAtElevation(
    baseColor: Color,
    tint: Color,
    elevation: Dp,
): Color {
    if (elevation == 0.dp) return baseColor
    val alpha = ((4.5f * ln(elevation.value + 1)) + 2f) / 100f
    return tint.copy(alpha = alpha).compositeOver(baseColor)
}

@Stable
fun Colors.surfaceColorAtElevation(elevation: Dp) = computeColorAtElevation(
    baseColor = highestEmphasisSurface,
    tint = primary,
    elevation = elevation
)