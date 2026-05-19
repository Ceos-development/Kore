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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ceos.development.kore.ui.components.dropdown.models.DropdownItem
import com.ceos.development.kore.ui.theming.icons.IconsPack

@Composable
fun <T: DropdownItem> LargeDropdownMenu(
    label: String,
    modifier: Modifier = Modifier,
    state: DropdownState<T> = remember { DropdownState() },
    enabled: Boolean = true,
    notSetLabel: String? = null,
    selectedItemToString: @Composable (T) -> String = { it.displayText },
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
        label = label,
        items = items,
        modifier = modifier,
        enabled = enabled,
        notSetLabel = notSetLabel,
        selectedIndex = state.selectedIndex,
        onItemSelected = state::onItemSelected,
        selectedItemToString = selectedItemToString,
        drawItem = drawItem,
    )
}


@Composable
fun <T: DropdownItem> LargeDropdownMenu(
    label: String,
    items: List<T>,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    notSetLabel: String? = null,
    selectedIndex: Int = -1,
    onItemSelected: (index: Int, item: T) -> Unit,
    selectedItemToString: @Composable (T) -> String = { it.displayText },
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
    Box(modifier = modifier.height(IntrinsicSize.Min)) {
        OutlinedTextField(
            label = { Text(label) },
            value = items.getOrNull(selectedIndex)?.let { selectedItemToString(it) } ?: "",
            enabled = enabled,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                val icon = if (expanded) IconsPack.current.dropDownExpanded else IconsPack.current.dropDownCollapsed
                Icon(icon, "")
            },
            onValueChange = { },
            readOnly = true,
        )

        // Transparent clickable surface on top of OutlinedTextField
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
                .clip(MaterialTheme.shapes.extraSmall)
                .clickable(enabled = enabled) { expanded = true },
            color = Color.Transparent,
        ) {}
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