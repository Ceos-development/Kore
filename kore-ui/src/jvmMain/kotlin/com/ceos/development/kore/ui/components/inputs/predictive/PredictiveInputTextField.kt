package com.ceos.development.kore.ui.components.inputs.predictive

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Text
import androidx.compose.material.ripple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ceos.development.kore.ui.components.inputs.BasicFormInputDefaults
import com.ceos.development.kore.ui.components.inputs.BasicFormInputDefaults.BasicFormInputColors
import com.ceos.development.kore.ui.theming.colors.Colors
import com.ceos.development.kore.ui.theming.typographies.Typographies

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PredictiveInputTextField(
    state: PredictiveTextFieldState,
    modifier: Modifier = Modifier,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: BasicFormInputColors = BasicFormInputDefaults.colors(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onKeyboardAction: KeyboardActionHandler? = null,
    textAlign: TextAlign = TextAlign.Start,
    textStyle: TextStyle = Typographies.current.body.copy(
        textAlign = textAlign,
    ),
    predictionItemContent: @Composable (Prediction, () -> Unit) -> Unit = { value, actionHandler ->
        PredictionItemContent(value, actionHandler)
    },
) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded && state.predictions.isNotEmpty(),
        onExpandedChange = { expanded = !expanded }
    ) {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = textStyle,
            cursorBrush = SolidColor(colors.cursor),
            state = state.textFieldState,
            decorator = { innerTextField ->
                Row(
                    Modifier
                        .background(colors.container, shape)
                        .border(BorderStroke(1.dp, colors.border), shape)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    innerTextField()
                }
            },
            lineLimits = lineLimits,
            keyboardOptions = keyboardOptions,
            onKeyboardAction = onKeyboardAction,
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            state.predictions.forEach { prediction ->
                predictionItemContent(prediction) {
                    state.edit {
                        replace(0, length, prediction.value)
                    }
                    expanded = false
                }
            }
        }
    }
}

@Composable
internal fun PredictionItemContent(
    prediction: Prediction,
    onClick: () -> Unit,
) {
    val textStyle = Typographies.current.label.copy(color = Colors.current.onSurface)
    val value = prediction.value
    Row(
        modifier = Modifier
            .clickable(
                onClick = onClick,
                interactionSource = null,
                indication = ripple(true),
            )
            .fillMaxWidth()
            // Preferred min and max width used during the intrinsic measurement.
            .sizeIn(
                minWidth = 112.dp,
                maxWidth = 280.dp,
                minHeight = 48.dp,
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        when (value) {
            is AnnotatedString -> Text(value, style = textStyle)
            else -> Text(value.toString(), style = textStyle)
        }
    }
}
