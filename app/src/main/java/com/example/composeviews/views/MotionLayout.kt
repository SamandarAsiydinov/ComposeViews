package com.example.composeviews.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import com.example.composeviews.util.Objects

@ExperimentalMotionApi
@Composable
fun MyMotionLayout() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar {
                    Text(
                        text = "MotionLayout",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                MotionLayoutButton()
            }
        }
    }
}

@ExperimentalMotionApi
@Composable
fun MotionLayoutButton() {
    var animateButton by remember { mutableStateOf(false) }
    val buttonAnimProgress by animateFloatAsState(
        targetValue = if (animateButton) 1f else 0f,
        animationSpec = tween(1000)
    )
    MotionLayout(
        ConstraintSet(
            Objects.json1
        ),
        ConstraintSet(
            Objects.json2
        ),
        progress = buttonAnimProgress,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Button(
            onClick = {
                animateButton = !animateButton
            },
            modifier = Modifier.layoutId("button1")
        ) {
            Text(text = "Button 1")
        }
        Button(
            onClick = {
                animateButton = !animateButton
            },
            modifier = Modifier.layoutId("button2")
        ) {
            Text(text = "Button 2")
        }
        Button(
            onClick = {
                animateButton = !animateButton
            },
            modifier = Modifier.layoutId("button3")
        ) {
            Text(text = "Button 3")
        }
    }
}