package com.ceos.development.kore.ui.components.inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.maxTextLength
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ceos.development.kore.ui.components.inputs.BasicFormInputDefaults.BasicFormInputColors
import com.ceos.development.kore.ui.theming.typographies.Typographies
import java.text.DecimalFormatSymbols
import java.util.*

@Composable
fun PriceInputField(
    modifier: Modifier = Modifier,
    input: TextFieldState,
    focusRequester: FocusRequester,
    shape: Shape = RoundedCornerShape(8.dp),
    colors: BasicFormInputColors = BasicFormInputDefaults.colors(),
    textStyle: TextStyle = Typographies.current.body,
    sign: String = "$",
    onKeyboardAction: KeyboardActionHandler? = null,
) {

    BasicTextField(
        modifier = modifier.focusRequester(focusRequester),
        textStyle = textStyle,
        cursorBrush = SolidColor(colors.cursor),
        state = input,
        decorator = { innerTextField ->
            Row(
                Modifier
                    .background(colors.container, shape)
                    .border(BorderStroke(1.dp, colors.border), shape)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                innerTextField()
                Spacer(Modifier.width(8.dp))
                Text(text = sign)
            }
        },
        inputTransformation = MaxLengthFilter(5),
        outputTransformation = CurrencyOutputTransformation(),
        lineLimits = TextFieldLineLimits.SingleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        onKeyboardAction = onKeyboardAction,
    )
}

class CurrencyOutputTransformation(
    private val locale: Locale = Locale.getDefault(),
    private val numberOfDecimals: Int = 2,
) : OutputTransformation {
    private val decimalSeparator = DecimalFormatSymbols(locale).decimalSeparator
    override fun TextFieldBuffer.transformOutput() {

        val pad = (numberOfDecimals + 1) - length
        repeat(pad) {
            insert(0, "0")
        }

        insert(length - numberOfDecimals, decimalSeparator.toString())
    }

}

private data class MaxLengthFilter(
    private val maxLength: Int
) : InputTransformation {

    init {
        require(maxLength >= 0) { "maxLength must be at least zero, was $maxLength" }
    }

    override fun SemanticsPropertyReceiver.applySemantics() {
        maxTextLength = maxLength
    }

    override fun TextFieldBuffer.transformInput() {
        if (length > maxLength) {
            revertAllChanges()
        }
    }

    override fun toString(): String {
        return "InputTransformation.maxLength($maxLength)"
    }
}