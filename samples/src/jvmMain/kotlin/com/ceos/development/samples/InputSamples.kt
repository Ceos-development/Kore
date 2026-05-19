package com.ceos.development.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ceos.development.kore.ui.components.inputs.BasicFormInput
import com.ceos.development.kore.ui.theming.colors.Colors

@Preview
@Composable
fun InputSamples() {
    Column(modifier = Modifier.fillMaxSize().background(Colors.current.background)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "Label 1:",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.5.sp,
                )
            )
            BasicFormInput(
                state = TextFieldState(),
            )
        }
    }
}