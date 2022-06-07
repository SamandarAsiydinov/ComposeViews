package com.example.composeviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeviews.canvas.ComposeCanvas
import com.example.composeviews.curvedScroll.CurvedScroll
import com.example.composeviews.draggable.Draggable
import com.example.composeviews.lazy.ItemSelectable
import com.example.composeviews.nestedscrollview.NestedScrollView
import com.example.composeviews.swipe.SwipeRefreshCompose
import com.example.composeviews.ui.theme.ComposeViewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ItemSelectable()
                   // ComposeCanvas()
                    //Draggable()
                    //CurvedScroll()
                    //SwipeRefreshCompose()
                    //NestedScrollView()
                }
            }
        }
    }
}
