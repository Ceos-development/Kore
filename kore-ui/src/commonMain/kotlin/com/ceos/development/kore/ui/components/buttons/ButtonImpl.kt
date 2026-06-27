package com.ceos.development.kore.ui.components.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ceos.development.kore.ui.components.buttons.models.ButtonColors
import com.ceos.development.kore.ui.components.buttons.models.ButtonState
import com.ceos.development.kore.ui.components.buttons.models.ButtonType
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun ButtonImpl(
    colors: ButtonColors,
    text: String,
    textStyle: TextStyle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    buttonState: ButtonState = ButtonState(),
    buttonType: ButtonType = ButtonType.PRIMARY,
    startingIcon: DrawableResource? = null,
    endingIcon: DrawableResource? = null
) {
    val contentColor = if (buttonState.isEnabled) colors.contentColor else colors.disabledContentColor
    val buttonColor = ButtonDefaults.buttonColors(
        containerColor = colors.containerColor,
        contentColor = colors.contentColor,
        disabledContainerColor = colors.disabledContainerColor,
        disabledContentColor = colors.disabledContentColor
    )
    val buttonContent = buttonContentOf(
        text = text,
        textStyle = textStyle,
        startingIcon = startingIcon,
        endingIcon = endingIcon,
        buttonState = buttonState,
        contentColor = contentColor
    )

    when (buttonType) {
        ButtonType.PRIMARY -> Button(
            modifier = modifier,
            colors = buttonColor,
            contentPadding = contentPadding,
            enabled = buttonState.isEnabled,
            onClick = onClick,
            content = buttonContent
        )

        ButtonType.SECONDARY -> OutlinedButton(
            modifier = modifier,
            colors = buttonColor,
            contentPadding = contentPadding,
            enabled = buttonState.isEnabled,
            onClick = onClick,
            content = buttonContent
        )

        ButtonType.TERTIARY -> TextButton(
            modifier = modifier,
            colors = buttonColor,
            contentPadding = contentPadding,
            enabled = buttonState.isEnabled,
            onClick = onClick,
            content = buttonContent
        )
    }
}

private fun buttonContentOf(
    text: String,
    textStyle: TextStyle,
    startingIcon: DrawableResource?,
    endingIcon: DrawableResource?,
    buttonState: ButtonState,
    contentColor: Color
): @Composable RowScope.() -> Unit = {
    Box(
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = contentColor,
            modifier = Modifier
                .size(24.dp)
                .alpha(if (buttonState.isLoading) 1f else 0f)
        )
        Row(
            modifier = Modifier.alpha(if (buttonState.isLoading) 0f else 1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            startingIcon?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                fontSize = textStyle.fontSize,
                color = contentColor,
                fontWeight = textStyle.fontWeight ?: FontWeight.Normal,
                lineHeight = textStyle.lineHeight,
            )
            endingIcon?.let {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(it),
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}