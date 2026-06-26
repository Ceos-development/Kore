package com.ceos.development.kore.ui.components.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ceos.development.kore.ui.theming.colors.Colors
import com.ceos.development.kore.ui.theming.typographies.Typographies

@Composable
fun TextInputDialog(
    title: String,
    primaryLabel: String,
    secondaryLabel: String,
    onDismiss: (String?) -> Unit
) {

    var input by remember { mutableStateOf("") }
    Dialog(
        onDismissRequest = {
            onDismiss.invoke(null)
        },
        content = {
            Surface(
                shape = RoundedCornerShape(28.dp),
                color = Colors.current.surface,
                tonalElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = title,
                        color = Colors.current.onSurface,
                        style = Typographies.current.body
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusTarget(),
                        value = input,
                        onValueChange = { input = it },
                        keyboardActions = KeyboardActions(
                            onDone = {
                                onDismiss.invoke(input)
                            }
                        )
                    )
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Spacer(modifier = Modifier.weight(1F))
                        TextButton(
                            onClick = { onDismiss.invoke(null) }
                        ) {
                            Text(
                                text = secondaryLabel,
                                style = Typographies.current.label,
                                color = Colors.current.primary
                            )
                        }
                        TextButton(
                            onClick = { onDismiss.invoke(input) }
                        ) {
                            Text(
                                text = primaryLabel,
                                style = Typographies.current.label,
                                color = Colors.current.primary
                            )
                        }
                    }
                }
            }
        }
    )
}