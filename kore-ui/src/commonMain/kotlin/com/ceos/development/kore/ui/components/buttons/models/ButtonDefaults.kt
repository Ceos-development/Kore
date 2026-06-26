package com.ceos.development.kore.ui.components.buttons.models

import androidx.compose.runtime.Composable
import com.ceos.development.kore.ui.theming.colors.Colors

object ButtonDefaults {
    val primaryColors: ButtonColors
        @Composable
        get() = ButtonColors(
            containerColor = Colors.current.primary,
            contentColor = Colors.current.onPrimary,
            disabledContainerColor = Colors.current.primaryDisabled,
            disabledContentColor = Colors.current.onPrimaryDisabled
        )
    val secondaryColors: ButtonColors
        @Composable
        get() = ButtonColors(
            containerColor = Colors.current.secondary,
            contentColor = Colors.current.onSecondary,
            disabledContainerColor = Colors.current.secondaryDisabled,
            disabledContentColor = Colors.current.onSecondaryDisabled
        )
    val tertiaryColors: ButtonColors
        @Composable
        get() = ButtonColors(
            containerColor = Colors.current.secondary,
            contentColor = Colors.current.onSecondary,
            disabledContainerColor = Colors.current.secondaryDisabled,
            disabledContentColor = Colors.current.onSecondaryDisabled
        )
}