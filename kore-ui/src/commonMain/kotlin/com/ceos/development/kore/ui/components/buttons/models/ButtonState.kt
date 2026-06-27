package com.ceos.development.kore.ui.components.buttons.models

import androidx.compose.runtime.Stable

@Stable
data class ButtonState(val isLoading: Boolean = false, private val enabled: Boolean = true) {
    val isEnabled: Boolean = enabled && isLoading.not()
    companion object {
        val loading = ButtonState(isLoading = true, enabled = false)
        val enabled = ButtonState(isLoading = false, enabled = true)
    }
}