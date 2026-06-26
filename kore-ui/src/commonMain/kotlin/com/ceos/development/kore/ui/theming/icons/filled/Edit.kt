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

public val Edit: ImageVector
    get() {
        if (_Edit != null) {
            return _Edit!!
        }
        _Edit = ImageVector.Builder(
            name = "Edit",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveToRelative(7f, 17.013f)
                lineToRelative(4.413f, -0.015f)
                lineToRelative(9.632f, -9.54f)
                curveToRelative(0.378f, -0.378f, 0.586f, -0.88f, 0.586f, -1.414f)
                reflectiveCurveToRelative(-0.208f, -1.036f, -0.586f, -1.414f)
                lineToRelative(-1.586f, -1.586f)
                curveToRelative(-0.756f, -0.756f, -2.075f, -0.752f, -2.825f, -0.003f)
                lineTo(7f, 12.583f)
                verticalLineToRelative(4.43f)
                close()
                moveTo(18.045f, 4.458f)
                lineToRelative(1.589f, 1.583f)
                lineToRelative(-1.597f, 1.582f)
                lineToRelative(-1.586f, -1.585f)
                lineToRelative(1.594f, -1.58f)
                close()
                moveTo(9f, 13.417f)
                lineToRelative(6.03f, -5.973f)
                lineToRelative(1.586f, 1.586f)
                lineToRelative(-6.029f, 5.971f)
                lineTo(9f, 15.006f)
                verticalLineToRelative(-1.589f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(5f, 21f)
                horizontalLineToRelative(14f)
                curveToRelative(1.103f, 0f, 2f, -0.897f, 2f, -2f)
                verticalLineToRelative(-8.668f)
                lineToRelative(-2f, 2f)
                verticalLineTo(19f)
                horizontalLineTo(8.158f)
                curveToRelative(-0.026f, 0f, -0.053f, 0.01f, -0.079f, 0.01f)
                curveToRelative(-0.033f, 0f, -0.066f, -0.009f, -0.1f, -0.01f)
                horizontalLineTo(5f)
                verticalLineTo(5f)
                horizontalLineToRelative(6.847f)
                lineToRelative(2f, -2f)
                horizontalLineTo(5f)
                curveToRelative(-1.103f, 0f, -2f, 0.897f, -2f, 2f)
                verticalLineToRelative(14f)
                curveToRelative(0f, 1.103f, 0.897f, 2f, 2f, 2f)
                close()
            }
        }.build()

        return _Edit!!
    }

@Suppress("ObjectPropertyName")
private var _Edit: ImageVector? = null

@Preview
@Composable
private fun EditPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Edit, contentDescription = null)
    }
}
