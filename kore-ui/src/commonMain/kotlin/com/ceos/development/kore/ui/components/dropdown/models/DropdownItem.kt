package com.ceos.development.kore.ui.components.dropdown.models

import androidx.compose.runtime.Composable

interface DropdownItem {
    @get:Composable
    val displayText: String
}