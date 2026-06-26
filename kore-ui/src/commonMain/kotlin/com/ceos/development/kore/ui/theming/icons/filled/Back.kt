package com.ceos.development.kore.ui.theming.icons.filled

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

public val Back: ImageVector
    get() {
        if (_Back != null) {
            return _Back!!
        }
        _Back = ImageVector.Builder(
            name = "Back",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveToRelative(15f, 18f)
                lineToRelative(-6f, -6f)
                lineToRelative(6f, -6f)
            }
        }.build()

        return _Back!!
    }

@Suppress("ObjectPropertyName")
private var _Back: ImageVector? = null

@Preview
@Composable
private fun BackPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Back, contentDescription = null)
    }
}
