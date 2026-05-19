package com.ceos.development.kore.ui.components.dropdown

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ceos.development.kore.ui.components.dropdown.models.DropdownItem
import com.ceos.development.kore.ui.theming.icons.IconsPack

@Composable
fun <T : DropdownItem> PopupDropdown(
    state: DropdownState<T>,
    modifier: Modifier = Modifier,
    container: @Composable (
        value: String,
        onClick: () -> Unit,
    ) -> Unit = { v, c -> DropdownDisplayFieldImpl(v, c) },
    dropdownItemRenderer: @Composable (value: T) -> Unit = { Text(text = it.displayText) },
) {
    var isDropDownExpanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        container(
            state.selectedItem?.displayText.orEmpty(),
        ) { isDropDownExpanded = true }

        DropdownMenu(
            expanded = isDropDownExpanded,
            onDismissRequest = { isDropDownExpanded = false }
        ) {
            state.choices.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { dropdownItemRenderer.invoke(item) },
                    onClick = {
                        isDropDownExpanded = false
                        state.onItemSelected(index, item)
                    }
                )
            }
        }
    }
}

@Composable
private fun DropdownDisplayFieldImpl(
    value: String,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(enabled = true, onClick = onClick)
    ) {
        Text(text = value)

        Icon(
            imageVector = IconsPack.current.dropDownExpanded,
            contentDescription = null
        )
    }
}