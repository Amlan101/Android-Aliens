package com.example.mysecondapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListDisplayLazily()
        }
    }
}

@Composable
fun ListDisplay(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.verticalScroll(scrollState)
    )
    {
        for (i in 1..50) {
            Text(
                text = "Girlfriend Number: $i",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListDisplayLazily() {
    LazyColumn() {
        items(500) {
            Text(
                text = "Girlfriend Number:$it",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
        }
    }
}

// https://www.youtube.com/watch?v=xc8nAcVvpxY -> Android Aliens Game
// https://developer.android.com/jetpack/compose/lists -> Lazy Layouts Official documentation
// https://www.youtube.com/watch?v=1ANt65eoNhQ -> Lazy Layouts Official vods

@Composable
fun AndroidAlien(
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = modifier,
        colorFilter = ColorFilter.tint(color = color)
    )
}

@Composable
fun AndroidAliensRow() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Arrangement.Top
    ) {
        AndroidAlien(
            color = Color.RED,
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.RED,
            modifier = Modifier
                .weight(2f)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
    }
}

@Composable
fun AndroidAliensGameOverBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AndroidAliensRow()
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(color = Color.GRAY.copy(alpha = .7f))
        )
        Text(
            text = "GAME OVER"
        )
    }
}