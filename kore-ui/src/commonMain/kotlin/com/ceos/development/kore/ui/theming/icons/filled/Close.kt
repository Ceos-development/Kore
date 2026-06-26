package com.ceos.development.kore.ui.theming.icons.filled

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

public val Close: ImageVector
    get() {
        if (_Close != null) {
            return _Close!!
        }
        _Close = ImageVector.Builder(
            name = "Close",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 0f,
                strokeAlpha = 0f
            ) {
                moveTo(24f, 24f)
                lineToRelative(-24f, -0f)
                lineToRelative(-0f, -24f)
                lineToRelative(24f, -0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(13.41f, 12f)
                lineToRelative(4.3f, -4.29f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = false, -1.42f, -1.42f)
                lineTo(12f, 10.59f)
                lineToRelative(-4.29f, -4.3f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.42f, 1.42f)
                lineToRelative(4.3f, 4.29f)
                lineToRelative(-4.3f, 4.29f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 1.42f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.42f, 0f)
                lineToRelative(4.29f, -4.3f)
                lineToRelative(4.29f, 4.3f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.42f, 0f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -1.42f)
                close()
            }
        }.build()

        return _Close!!
    }

@Suppress("ObjectPropertyName")
private var _Close: ImageVector? = null

@Preview
@Composable
private fun ClosePreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Close, contentDescription = null)
    }
}
