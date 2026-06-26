package com.ceos.development.kore.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.placeCursorAtEnd
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import com.ceos.development.kore.ui.components.inputs.PredictiveTextFieldDefaults.PredictiveTextFieldColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PredictiveTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    predictions: List<String>,
    colors: PredictiveTextFieldColors = PredictiveTextFieldDefaults.colors(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onKeyboardAction: KeyboardActionHandler? = null,
    onFocusChanged: (FocusState) -> Unit = {},
    focusRequester: FocusRequester = remember { FocusRequester() }
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded && predictions.isNotEmpty(),
        onExpandedChange = { expanded = it },
    ) {
        BasicFormInput(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChanged(it)
                }
                .focusRequester(focusRequester),
            state = state,
            keyboardOptions = keyboardOptions,
            onKeyboardAction = onKeyboardAction,
            colors = BasicFormInputDefaults.colors(
                border = colors.border,
                container = colors.container,
                content = colors.content,
                cursor = colors.cursor,
            )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            predictions.forEach { prediction ->
                DropdownMenuItem(
                    text = {
                        Text(text = prediction)
                    },
                    onClick = {
                        state.edit {
                            replace(0, length, prediction)
                            placeCursorAtEnd()
                        }
                        expanded = false
                    }
                )
            }
        }
    }
}