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

public val Reset: ImageVector
    get() {
        if (_Reset != null) {
            return _Reset!!
        }
        _Reset = ImageVector.Builder(
            name = "Reset",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(12f, 16f)
                curveToRelative(1.671f, 0f, 3f, -1.331f, 3f, -3f)
                reflectiveCurveToRelative(-1.329f, -3f, -3f, -3f)
                reflectiveCurveToRelative(-3f, 1.331f, -3f, 3f)
                reflectiveCurveToRelative(1.329f, 3f, 3f, 3f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(20.817f, 11.186f)
                arcToRelative(8.94f, 8.94f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.355f, -3.219f)
                arcToRelative(9.053f, 9.053f, 0f, isMoreThanHalf = false, isPositiveArc = false, -2.43f, -2.43f)
                arcToRelative(8.95f, 8.95f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.219f, -1.355f)
                arcToRelative(9.028f, 9.028f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.838f, -0.18f)
                verticalLineTo(2f)
                lineTo(8f, 5f)
                lineToRelative(3.975f, 3f)
                verticalLineTo(6.002f)
                curveToRelative(0.484f, -0.002f, 0.968f, 0.044f, 1.435f, 0.14f)
                arcToRelative(6.961f, 6.961f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.502f, 1.053f)
                arcToRelative(7.005f, 7.005f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1.892f, 1.892f)
                arcTo(6.967f, 6.967f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19f, 13f)
                arcToRelative(7.032f, 7.032f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.55f, 2.725f)
                arcToRelative(7.11f, 7.11f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.644f, 1.188f)
                arcToRelative(7.2f, 7.2f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.858f, 1.039f)
                arcToRelative(7.028f, 7.028f, 0f, isMoreThanHalf = false, isPositiveArc = true, -3.536f, 1.907f)
                arcToRelative(7.13f, 7.13f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2.822f, 0f)
                arcToRelative(6.961f, 6.961f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2.503f, -1.054f)
                arcToRelative(7.002f, 7.002f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.89f, -1.89f)
                arcTo(6.996f, 6.996f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5f, 13f)
                horizontalLineTo(3f)
                arcToRelative(9.02f, 9.02f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.539f, 5.034f)
                arcToRelative(9.096f, 9.096f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2.428f, 2.428f)
                arcTo(8.95f, 8.95f, 0f, isMoreThanHalf = false, isPositiveArc = false, 12f, 22f)
                arcToRelative(9.09f, 9.09f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.814f, -0.183f)
                arcToRelative(9.014f, 9.014f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.218f, -1.355f)
                arcToRelative(8.886f, 8.886f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.331f, -1.099f)
                arcToRelative(9.228f, 9.228f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.1f, -1.332f)
                arcTo(8.952f, 8.952f, 0f, isMoreThanHalf = false, isPositiveArc = false, 21f, 13f)
                arcToRelative(9.09f, 9.09f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.183f, -1.814f)
                close()
            }
        }.build()

        return _Reset!!
    }

@Suppress("ObjectPropertyName")
private var _Reset: ImageVector? = null

@Preview
@Composable
private fun ResetPreview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Reset, contentDescription = null)
    }
}
