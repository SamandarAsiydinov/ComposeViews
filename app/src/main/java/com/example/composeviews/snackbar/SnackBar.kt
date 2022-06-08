package com.example.composeviews.snackbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.composeviews.ui.theme.Purple500
import kotlinx.coroutines.launch

@Composable
fun MySnackBar() {
    val scaffoldState: ScaffoldState = rememberScaffoldState(
        snackbarHostState = SnackbarHostState()
    )
    val visibleState = remember { mutableStateOf(false) }
    val snackBarMessage = remember { mutableStateOf("") }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Jetpack Compose SnackBar",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                backgroundColor = Purple500
            )
        },
        content = {
            ShowSnackBar(visibleState, snackBarMessage)
        },
        backgroundColor = Color.White,
        snackbarHost = {
            if (visibleState.value) {
                Snackbar(
                    action = {
                        TextButton(onClick = { visibleState.value = !visibleState.value }) {
                            Text(
                                text = "Undo",
                                color = Color.Blue
                            )
                        }
                    },
                    content = {
                        Text(
                            text = snackBarMessage.value
                        )
                    },
                    backgroundColor = Color(0xFF2D852D)
                )
            }
        }
    )
}

@Composable
fun ShowSnackBar(
    visibleState: MutableState<Boolean>,
    message: MutableState<String>
) {
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = {
                scope.launch {
                    visibleState.value = !visibleState.value
                    message.value = "Item was deleted"
                }
            }
        ) {
            Text(text = "Show SnackBar")
        }
    }
}