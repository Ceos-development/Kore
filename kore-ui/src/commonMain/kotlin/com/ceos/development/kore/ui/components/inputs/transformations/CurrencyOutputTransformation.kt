package com.ceos.development.kore.ui.components.inputs.transformations

import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.insert
import java.text.DecimalFormatSymbols
import java.util.*

class CurrencyOutputTransformation(
    private val locale: Locale = Locale.getDefault(),
    private val numberOfDecimals: Int = 2,
) : OutputTransformation {

    private val decimalSeparator = DecimalFormatSymbols.getInstance(locale).decimalSeparator

    override fun TextFieldBuffer.transformOutput() {
        val pad = (numberOfDecimals + 1) - length
        repeat(pad) {
            insert(0, "0")
        }

        insert(length - numberOfDecimals, decimalSeparator.toString())
    }
}