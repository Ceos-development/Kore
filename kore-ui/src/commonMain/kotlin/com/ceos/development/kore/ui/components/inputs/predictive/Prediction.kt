package com.ceos.development.kore.ui.components.inputs.predictive

interface Prediction {
    val weight: Float
    val value: CharSequence
}

data class PredictionImpl(
    override val value: CharSequence,
    override val weight: Float = 1F
) : Prediction