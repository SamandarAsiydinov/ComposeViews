package com.example.composeviews.canvas

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeviews.ui.theme.Purple500

@Composable
fun ComposeCircle(
    percentage: Float,
    fontSize: TextUnit = 25.sp,
    radius: Dp = 100.dp,
    strokeWidth: Dp = 15.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    val animationPlayed = remember { mutableStateOf(false) }

    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed.value) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(
        key1 = true
    ) {
        animationPlayed.value = !animationPlayed.value
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawCircle(
                SolidColor(Color.LightGray),
                radius = size.width / 2,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            val convertVal = (curPercentage.value / 30) * 360

            drawArc(
                color = Color.Blue,
                startAngle = -90f,
                sweepAngle = convertVal,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (curPercentage.value).toInt().toString(),
            color = Purple500,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}