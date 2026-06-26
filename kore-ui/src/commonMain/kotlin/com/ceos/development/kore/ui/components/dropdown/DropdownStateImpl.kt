package com.ceos.development.kore.ui.components.dropdown

import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ceos.development.kore.ui.components.dropdown.models.DropdownItem
import com.ceos.development.kore.ui.components.dropdown.models.DropdownState


@Stable
class DropdownStateImpl<T: DropdownItem>(
    choices: List<T> = emptyList(),
    selectedIndex: Int = -1
): DropdownState<T> {
    override val choices: SnapshotStateList<T> = mutableStateListOf()
    override var selectedIndex: Int by mutableStateOf(selectedIndex)
        private set
    override var selectedItem: T? by mutableStateOf(choices.getOrNull(selectedIndex))
        private set

    init {
        this.choices.addAll(choices)
    }

    override fun onItemSelected(index: Int, item: T) {
        selectedItem = item
        selectedIndex = index
    }

    override fun setChoices(choices: List<T>) {
        this.choices.apply {
            clear()
            addAll(choices)
        }
        selectedItem = choices.getOrNull(selectedIndex)
    }

    override fun select(predicate: (index: Int, item: T) -> Boolean): Boolean {
        choices.forEachIndexed { index, item ->
            if (predicate(index, item)) {
                onItemSelected(index, item)
                return true
            }
        }
        return false
    }
}
