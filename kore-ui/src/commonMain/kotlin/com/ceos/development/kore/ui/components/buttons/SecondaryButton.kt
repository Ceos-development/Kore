package com.ceos.development.kore.ui.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.ceos.development.kore.ui.components.buttons.models.ButtonColors
import com.ceos.development.kore.ui.components.buttons.models.ButtonDefaults.secondaryColors
import com.ceos.development.kore.ui.components.buttons.models.ButtonState
import com.ceos.development.kore.ui.components.buttons.models.ButtonType
import com.ceos.development.kore.ui.theming.typographies.Typographies
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = Typographies.current.button,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    buttonState: ButtonState = ButtonState(),
    colors: ButtonColors = secondaryColors,
    startingIcon: DrawableResource? = null,
    endingIcon: DrawableResource? = null
) {
    ButtonImpl(
        colors = colors,
        text = text,
        textStyle = textStyle,
        onClick = onClick,
        modifier = modifier,
        contentPadding = contentPadding,
        buttonState = buttonState,
        buttonType = ButtonType.SECONDARY,
        startingIcon = startingIcon,
        endingIcon = endingIcon
    )
}