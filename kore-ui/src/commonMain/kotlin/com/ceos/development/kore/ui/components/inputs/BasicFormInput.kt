package com.ceos.development.kore.ui.components.inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ceos.development.kore.ui.components.inputs.BasicFormInputDefaults.BasicFormInputColors
import com.ceos.development.kore.ui.theming.typographies.Typographies

@Composable
fun BasicFormInput(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: BasicFormInputColors = BasicFormInputDefaults.colors(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    inputTransformation: InputTransformation? = BasicFormInputDefaults.inputTransformation,
    outputTransformation: OutputTransformation? = BasicFormInputDefaults.outputTransformation,
    onKeyboardAction: KeyboardActionHandler? = null,
    textAlign: TextAlign = TextAlign.Start,
    textStyle: TextStyle = Typographies.current.body.copy(
        textAlign = textAlign,
    )
) {
    BasicTextField(
        modifier = modifier,
        textStyle = textStyle,
        cursorBrush = SolidColor(colors.cursor),
        inputTransformation = inputTransformation,
        outputTransformation = outputTransformation,
        state = state,
        decorator = { innerTextField ->
            Row(
                Modifier
                    .background(colors.container, shape)
                    .border(BorderStroke(1.dp, colors.border), shape)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = when (textAlign) {
                    TextAlign.Center -> Arrangement.Center
                    TextAlign.End -> Arrangement.End
                    else -> Arrangement.Start
                },
            ) {
                innerTextField()
            }
        },
        lineLimits = lineLimits,
        keyboardOptions = keyboardOptions,
        onKeyboardAction = onKeyboardAction,
    )
}