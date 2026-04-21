package com.ceos.development.kore.ui.components.search

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.ceos.development.kore.ui.components.search.SearchBarDefaults.SearchBarColors
import com.ceos.development.kore.ui.theming.icons.IconsPack
import com.ceos.development.kore.ui.theming.typographies.Typographies

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: ImageVector = IconsPack.current.search,
    colors: SearchBarColors = SearchBarDefaults.colors(),
    textStyle: TextStyle = Typographies.current.label
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        leadingIcon = {
            Icon(
                leadingIcon,
                contentDescription = null,
                tint = colors.contentColor
            )
        },
        shape = RoundedCornerShape(6.dp),
        placeholder = {
            Text(
                text = hint,
                style = textStyle
            )
        },
        trailingIcon = trailingIcon
    )
}