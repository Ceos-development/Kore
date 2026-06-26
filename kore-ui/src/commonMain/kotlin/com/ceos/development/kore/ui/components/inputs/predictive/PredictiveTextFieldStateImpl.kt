package com.ceos.development.kore.ui.components.inputs.predictive

import androidx.compose.foundation.text.input.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.text.TextRange
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun rememberPredictiveTextFieldState(
    initialText: String = "",
    initialSelection: TextRange = TextRange(initialText.length),
    debounce: Duration = 300.milliseconds,
    predictionsProvider: (CharSequence) -> List<Prediction> = { listOf(PredictionImpl(it)) },
): PredictiveTextFieldState = PredictiveTextFieldStateImpl(
    coroutineScope = rememberCoroutineScope(),
    textFieldState = rememberTextFieldState(initialText, initialSelection),
    debounce = debounce,
    predictionsProvider = predictionsProvider,
)

fun ViewModel.predictiveTextFieldState(
    coroutineScope: CoroutineScope = viewModelScope,
    initialText: String = "",
    initialSelection: TextRange = TextRange(initialText.length),
    debounce: Duration = 300.milliseconds,
    predictionsProvider: (CharSequence) -> List<Prediction> = { listOf(PredictionImpl(it)) },
): PredictiveTextFieldState =
    PredictiveTextFieldStateImpl(
        coroutineScope = coroutineScope,
        textFieldState = TextFieldState(initialText, initialSelection),
        debounce = debounce,
        predictionsProvider = predictionsProvider,
    )

internal class PredictiveTextFieldStateImpl(
    private val coroutineScope: CoroutineScope,
    override val textFieldState: TextFieldState = TextFieldState(),
    private val debounce: Duration = 300.milliseconds,
    private val predictionsProvider: (CharSequence) -> List<Prediction>,
) : PredictiveTextFieldState {

    init {
        coroutineScope.launch {
            snapshotFlow { textFieldState.text }
                .debounce(debounce)
                .collectLatest { query ->
                    _predictions.apply {
                        clear()
                        addAll(predictionsProvider.invoke(query).sortedBy { it.weight })
                    }
                }
        }
    }

    override fun updatePredictions(block: (CharSequence) -> List<Prediction>) {
        _predictions.apply {
            clear()
            addAll(block.invoke(textFieldState.text))
        }
    }

    /**
     * The current propositions to complete the text being written
     */
    private val _predictions = mutableStateListOf<Prediction>()
    override val predictions: List<Prediction> get() = _predictions


    /**
     * The current text content. This value will automatically update when the user enters text or
     * otherwise changes the text field contents. To change it programmatically, call [edit].
     *
     * To observe changes to this property outside a restartable function, use `snapshotFlow { text
     * }`.
     *
     * @sample androidx.compose.foundation.samples.BasicTextFieldTextValuesSample
     * @see edit
     * @see snapshotFlow
     */
    override val text: CharSequence
        get() = textFieldState.text

    /**
     * The current selection range. If the selection is collapsed, it represents cursor location.
     * This value will automatically update when the user enters text or otherwise changes the text
     * field selection range. To change it programmatically, call [edit].
     *
     * To observe changes to this property outside a restartable function, use `snapshotFlow {
     * selection }`.
     *
     * @see edit
     * @see snapshotFlow
     * @see TextFieldCharSequence.selection
     */
    val selection: TextRange
        get() = textFieldState.selection

    /**
     * The current composing range dictated by the IME. If null, there is no composing region.
     *
     * To observe changes to this property outside a restartable function, use `snapshotFlow {
     * composition }`.
     *
     * @see edit
     * @see snapshotFlow
     * @see TextFieldCharSequence.composition
     */
    override val composition: TextRange?
        get() = textFieldState.composition

    /**
     * Runs [block] with a mutable version of the current state. The block can make changes to the
     * text and cursor/selection. See the documentation on [TextFieldBuffer] for a more detailed
     * description of the available operations.
     *
     * Make sure that you do not make concurrent calls to this function or call it again inside
     * [block]'s scope. Doing either of these actions will result in triggering an
     * [IllegalStateException].
     *
     * @sample androidx.compose.foundation.samples.BasicTextFieldStateEditSample
     * @see setTextAndPlaceCursorAtEnd
     * @see setTextAndSelectAll
     */
    override fun edit(block: TextFieldBuffer.() -> Unit) = textFieldState.edit(block)

    override fun toString(): String =
        Snapshot.withoutReadObservation { "PredictiveTextFieldState(selection=$selection, text=\"$text\", predictions=$predictions) })" }
}