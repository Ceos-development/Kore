package com.ceos.development.kore.ui.components.inputs.transformations

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.ui.text.input.KeyboardType

object FloatDigitOnlyTransformation : InputTransformation {
    // Show a number keyboard with a decimal/sign pad
    override val keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    override fun TextFieldBuffer.transformInput() {
        val newText = asCharSequence().toString()

        // Regex to match: optional minus, followed by numbers,
        // optionally followed by one dot and more numbers
        val floatRegex = Regex("^-?[0-9]*[.,]?[0-9]*$")

        if (!newText.matches(floatRegex)) {
            revertAllChanges() // Discard invalid character entry
        }
    }
}