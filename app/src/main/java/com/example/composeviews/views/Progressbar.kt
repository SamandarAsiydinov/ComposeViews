package com.example.composeviews.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyProgressBar() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Custom Progressbar",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                )
            }
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CustomProgressBar(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(20.dp),
                    width = 300.dp,
                    backColor = Color.Gray,
                    foreColor = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF00B8D4),
                            Color(0xFF0091EA)
                        )
                    ),
                    percent = 75
                )
            }
        }
    }
}

@Composable
fun CustomProgressBar(
    modifier: Modifier,
    width: Dp,
    backColor: Color,
    foreColor: Brush,
    percent: Int,
) {
    Box(
        modifier = modifier
            .background(backColor)
            .width(width)
    ) {
        Box(modifier = modifier
            .background(foreColor)
            .width(width * percent / 100))
        Text(
            text = "$percent %",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}