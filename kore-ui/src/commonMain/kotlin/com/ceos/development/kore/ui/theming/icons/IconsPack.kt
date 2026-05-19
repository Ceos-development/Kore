package com.ceos.development.kore.ui.theming.icons

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import com.ceos.development.kore.ui.theming.icons.implementations.DefaultPack

interface IconsPack {
    val search: ImageVector
    val dropDownExpanded: ImageVector
    val dropDownCollapsed: ImageVector
    val setting: ImageVector
    val reset:ImageVector

    companion object {
        private var pack by mutableStateOf<IconsPack>(DefaultPack())

        internal fun setPack(pack: IconsPack) {
            Companion.pack = pack
        }

        val current: IconsPack
            get() = pack
    }
}