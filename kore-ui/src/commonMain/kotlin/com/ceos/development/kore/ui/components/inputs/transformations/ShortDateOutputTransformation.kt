package com.ceos.development.kore.ui.components.inputs.transformations

import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.insert

object ShortDateOutputTransformation : OutputTransformation {
    override fun TextFieldBuffer.transformOutput() {
        when (length) {
            1 -> insert(1, "000-00-00")
            2 -> insert(2, "00-00-00")
            3 -> insert(3, "0-00-00")
            4 -> insert(4, "-00-00")
            5 -> {
                insert(4, "-")
                insert(6, "0-00")

            }
            6 -> {
                insert(4, "-")
                insert(7, "-00")
            }
            7 -> {
                insert(4, "-")
                insert(7, "-")
                insert(9, "0")
            }
            8 -> {
                insert(4, "-")
                insert(7, "-")
            }
        }
    }
}