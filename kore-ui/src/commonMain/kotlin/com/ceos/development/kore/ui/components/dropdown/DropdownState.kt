package com.ceos.development.kore.ui.components.dropdown

import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList

@Stable
class DropdownState<T>(
    choices: List<T> = emptyList(),
    selectedIndex: Int = -1
) {
    val choices: SnapshotStateList<T> = mutableStateListOf()
    var selectedIndex: Int by mutableStateOf(selectedIndex)
        private set
    var selectedItem: T? by mutableStateOf(choices.getOrNull(selectedIndex))
        private set

    init {
        this.choices.addAll(choices)
    }

    fun onItemSelected(index: Int, item: T) {
        selectedItem = item
        selectedIndex = index
    }

    fun setChoices(choices: List<T>) {
        this.choices.apply {
            clear()
            addAll(choices)
        }
        selectedItem = choices.getOrNull(selectedIndex)
    }

    fun select(predicate: (index: Int, item: T) -> Boolean): Boolean {
        choices.forEachIndexed { index, item ->
            if (predicate(index, item)) {
                selectedItem = item
                selectedIndex = index
                return true
            }
        }
        return false
    }

}

inline fun <reified T> dropdownState(
    choices: List<T> = emptyList(),
    selectedIndex: Int = 0
): DropdownState<T> = DropdownState(choices, selectedIndex)