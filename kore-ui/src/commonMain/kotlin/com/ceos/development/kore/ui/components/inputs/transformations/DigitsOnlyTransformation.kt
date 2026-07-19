package com.ceos.development.kore.ui.components.inputs.transformations

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.ui.text.input.KeyboardType

class DigitsOnlyTransformation(
    private val lengthLimit: Int? = null,
) : InputTransformation {

    init {
        require(lengthLimit?.let { it > 0 } ?: true) {"lengthLimit can't lower 0"}
    }

    override val keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    override fun TextFieldBuffer.transformInput() {
        if (!asCharSequence().isStrictlyDigits() || asCharSequence().isWithingBounds().not()) {
            revertAllChanges()
        }
    }

    private fun CharSequence.isWithingBounds(): Boolean = if(lengthLimit == null) true else length <= lengthLimit
}

fun CharSequence.isStrictlyDigits(): Boolean {
    return this.isNotEmpty() && this.all { it.isDigit() }
}