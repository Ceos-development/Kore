package com.ceos.development.kore.ui.components.dropdown

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.ceos.development.kore.ui.components.ComponentsDefaults
import com.ceos.development.kore.ui.components.dropdown.models.DropdownItem
import com.ceos.development.kore.ui.components.dropdown.models.DropdownState
import com.ceos.development.kore.ui.theming.icons.IconsPack

@Composable
fun <T : DropdownItem> PopupDropdown(
    state: DropdownState<T>,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    colors: DropDownColors = ComponentsDefaults.Dropdown.colors,
    container: @Composable (
        value: T?,
        onClick: () -> Unit,
    ) -> Unit = { v, c -> DropdownDisplayFieldImpl(v?.displayText.orEmpty(), c) },
    dropdownItemRenderer: @Composable (value: T) -> Unit = { Text(text = it.displayText) },
) {
    var isDropDownExpanded by remember { mutableStateOf(false) }
    CompositionLocalProvider(
        LocalDropDownColors provides colors,
        LocalDropDownShape provides shape
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            container(
                state.selectedItem,
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
                        },
                        colors = MenuDefaults.itemColors(
                            textColor = colors.content
                        ),
                    )
                }
            }
        }
    }
}

@Composable
internal fun DropdownDisplayFieldImpl(
    value: String,
    onClick: () -> Unit,
) {
    val colors = LocalDropDownColors.current
    val shape = LocalDropDownShape.current
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
            .background(colors.container, shape = shape)
            .border(1.dp, colors.border, shape)
            .clickable(enabled = true, onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 4.dp),
    ) {
        Text(text = value, modifier = Modifier.weight(1f))

        Icon(
            imageVector = IconsPack.current.dropDownExpanded,
            contentDescription = null
        )
    }
}

internal val LocalDropDownShape = staticCompositionLocalOf { RectangleShape }