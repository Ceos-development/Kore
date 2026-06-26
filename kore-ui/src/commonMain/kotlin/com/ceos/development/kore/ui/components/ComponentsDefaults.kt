package com.ceos.development.kore.ui.components

import androidx.compose.runtime.Composable
import com.ceos.development.kore.ui.components.dropdown.DropDownColors
import com.ceos.development.kore.ui.theming.colors.Colors

object ComponentsDefaults {
    object Dialogs {}

    object Dropdown {
        val colors: DropDownColors
            @Composable
            get() = DropDownColors(
                content = Colors.current.onSurface,
                container = Colors.current.highestEmphasisSurface,
                border = Colors.current.outline
            )
    }
}