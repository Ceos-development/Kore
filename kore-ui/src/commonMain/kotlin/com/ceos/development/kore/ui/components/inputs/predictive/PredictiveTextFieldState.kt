package com.ceos.development.kore.ui.components.inputs.predictive

import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.ui.text.TextRange

interface PredictiveTextFieldState {
    val textFieldState: TextFieldState
    val composition: TextRange?
    val text: CharSequence
    val predictions: List<Prediction>

    fun edit(block: TextFieldBuffer.() -> Unit)
    fun updatePredictions(block: (CharSequence) -> List<Prediction>)
}