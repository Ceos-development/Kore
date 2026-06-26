package com.ceos.development.kore.ui.components.inputs.transformations

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.ui.text.input.KeyboardType

object DigitsOnlyTransformation : InputTransformation {
    override val keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    override fun TextFieldBuffer.transformInput() {
        if (!asCharSequence().isStrictlyDigits()) {
            revertAllChanges()
        }
    }
}

fun CharSequence.isStrictlyDigits(): Boolean {
    return this.isNotEmpty() && this.all { it.isDigit() }
}