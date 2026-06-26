package com.ceos.development.kore.ui.components.dropdown

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ceos.development.kore.ui.components.ComponentsDefaults
import com.ceos.development.kore.ui.components.dropdown.models.DropdownItem
import com.ceos.development.kore.ui.components.dropdown.models.DropdownState

@Composable
fun <T : DropdownItem> LargeDropdownMenu(
    state: DropdownState<T>,
    modifier: Modifier = Modifier,
    notSetLabel: String? = null,
    shape: Shape = RectangleShape,
    selectedItemToString: @Composable (T) -> String = { it.displayText },
    colors: DropDownColors = ComponentsDefaults.Dropdown.colors,
    drawItem: @Composable (T, Boolean, Boolean, () -> Unit) -> Unit = { item, selected, itemEnabled, onClick ->
        LargeDropdownMenuItem(
            text = item.displayText,
            selected = selected,
            enabled = itemEnabled,
            onClick = onClick,
        )
    }
) {
    val items = remember { state.choices }
    LargeDropdownMenu(
        items = items,
        modifier = modifier,
        notSetLabel = notSetLabel,
        selectedIndex = state.selectedIndex,
        shape = shape,
        colors = colors,
        onItemSelected = state::onItemSelected,
        selectedItemToString = selectedItemToString,
        drawItem = drawItem,
    )
}


@Composable
fun <T : DropdownItem> LargeDropdownMenu(
    items: List<T>,
    modifier: Modifier = Modifier,
    notSetLabel: String? = null,
    selectedIndex: Int = -1,
    shape: Shape = RectangleShape,
    onItemSelected: (index: Int, item: T) -> Unit,
    selectedItemToString: @Composable (T) -> String = { it.displayText },
    colors: DropDownColors = ComponentsDefaults.Dropdown.colors,
    drawItem: @Composable (T, Boolean, Boolean, () -> Unit) -> Unit = { item, selected, itemEnabled, onClick ->
        LargeDropdownMenuItem(
            text = item.displayText,
            selected = selected,
            enabled = itemEnabled,
            onClick = onClick,
        )
    },
) {
    var expanded by remember { mutableStateOf(false) }
    CompositionLocalProvider(
        LocalDropDownColors provides colors,
        LocalDropDownShape provides shape
    ) {
        Box(modifier = modifier.height(IntrinsicSize.Min)) {
            DropdownDisplayFieldImpl(
                value = items.getOrNull(selectedIndex)?.let { selectedItemToString(it) } ?: "",
                onClick = { expanded = true }
            )
        }
    }

    if (expanded) {
        Dialog(
            onDismissRequest = { expanded = false },
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
            ) {
                val listState = rememberLazyListState()
                if (selectedIndex > -1) {
                    LaunchedEffect("ScrollToSelected") {
                        listState.scrollToItem(index = selectedIndex)
                    }
                }

                LazyColumn(modifier = Modifier.fillMaxWidth(), state = listState) {
                    if (notSetLabel != null) {
                        item {
                            LargeDropdownMenuItem(
                                text = notSetLabel,
                                selected = false,
                                enabled = false,
                                onClick = { },
                            )
                        }
                    }
                    itemsIndexed(items) { index, item ->
                        val selectedItem = index == selectedIndex
                        drawItem(
                            item,
                            selectedItem,
                            true
                        ) {
                            onItemSelected(index, item)
                            expanded = false
                        }

                        if (index < items.lastIndex) {
                            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        }
                    }
                }
            }
        }
    }
}

private const val ALPHA_DISABLED = 0.6F
private const val ALPHA_FULL = 1F

@Composable
fun LargeDropdownMenuItem(
    text: String,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val contentColor = when {
        !enabled -> MaterialTheme.colorScheme.onSurface.copy(alpha = ALPHA_DISABLED)
        selected -> MaterialTheme.colorScheme.primary.copy(alpha = ALPHA_FULL)
        else -> MaterialTheme.colorScheme.onSurface.copy(alpha = ALPHA_FULL)
    }

    CompositionLocalProvider(LocalContentColor provides contentColor) {
        Box(
            modifier = Modifier
                .clickable(enabled) { onClick() }
                .fillMaxWidth()
                .padding(16.dp)) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}