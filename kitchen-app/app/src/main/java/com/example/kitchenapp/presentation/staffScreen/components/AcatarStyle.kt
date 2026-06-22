package com.example.kitchenapp.presentation.staffScreen.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

private const val ANGLE_DEG = 45.0
fun Modifier.drawStatusRing(
    statusColor: Color,
    glowBrush: Brush
): Modifier {
    return this.drawWithContent {
        drawContent()

        val containerRadiusPx = size.width / 2
        val borderThicknessPx = 2.dp.toPx()
        val dotRadiusPx = 10.dp.toPx()

        val angleRad = Math.toRadians(ANGLE_DEG)
        val dotCenterPx = Offset(
            x = containerRadiusPx + containerRadiusPx * kotlin.math.sin(angleRad).toFloat(),
            y = containerRadiusPx + containerRadiusPx * kotlin.math.sin(angleRad).toFloat()
        )

        val dotAngularSizeDeg = Math.toDegrees(
            kotlin.math.atan2(dotRadiusPx.toDouble(), containerRadiusPx.toDouble())
        ).toFloat()

        drawArc(
            color = statusColor,
            startAngle = 44f + dotAngularSizeDeg + 5f,
            sweepAngle = 360f - (dotAngularSizeDeg * 2f + 10f),
            useCenter = false,
            style = Stroke(width = borderThicknessPx, cap = StrokeCap.Round)
        )

        val dotOuterHoleRadiusPx = dotRadiusPx + (borderThicknessPx / 2) + 3.dp.toPx()

        drawCircle(
            color = Color.Black,
            radius = dotOuterHoleRadiusPx,
            center = dotCenterPx,
            blendMode = BlendMode.Clear
        )
        drawCircle(color = Color.Black, radius = dotOuterHoleRadiusPx, center = dotCenterPx)

        drawCircle(brush = glowBrush, radius = dotOuterHoleRadiusPx + 10.dp.toPx(), center = dotCenterPx)
        drawCircle(color = statusColor, radius = dotRadiusPx, center = dotCenterPx)
    }
}
