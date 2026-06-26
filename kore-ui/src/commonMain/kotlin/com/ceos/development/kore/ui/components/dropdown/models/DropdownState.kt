package com.ceos.development.kore.ui.components.dropdown.models

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ceos.development.kore.ui.components.dropdown.DropdownStateImpl

interface DropdownState<T: DropdownItem> {
    val selectedIndex: Int
    val selectedItem: T?
    val choices: SnapshotStateList<T>

    fun onItemSelected(index: Int, item: T)
    fun setChoices(choices: List<T>)
    fun select(predicate: (index: Int, item: T) -> Boolean): Boolean

    companion object {
        operator fun <T: DropdownItem> invoke(
            choices: List<T> = emptyList(),
            selectedIndex: Int = -1
        ): DropdownState<T> = DropdownStateImpl(choices, selectedIndex)
    }
}