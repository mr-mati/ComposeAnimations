package com.mati.composeanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mati.composeanimation.ui.theme.ComposeAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    var isVisible by remember {
                        mutableStateOf(true)
                    }

                    var isRound by remember {
                        mutableStateOf(false)
                    }

                    val transient = rememberInfiniteTransition(label = "")
                    val color by transient.animateColor(
                        initialValue = Color.Red,
                        targetValue = Color.Blue,
                        animationSpec = infiniteRepeatable(
                            animation = tween(500),
                            repeatMode = RepeatMode.Reverse
                        ),
                        label = ""
                    )

                    Box(
                        modifier = Modifier
                            .size(300.dp)
                            .background(color)
                    )

                    /*val transient = updateTransition(targetState = isRound, label = null)

                    val borderRound by transient.animateInt(
                        transitionSpec = { tween(200) },
                        label = "bordarRadius",
                        targetValueByState = { isRound ->
                            if (isRound) 100 else 0
                        }
                    )

                    val color by transient.animateColor(
                        transitionSpec = { tween(2000) },
                        label = "bordarRadius",
                        targetValueByState = { isRound ->
                            if (isRound) Color.White else Color.Red
                        }
                    )

                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(color)
                            .clip(RoundedCornerShape(borderRound))
                    )*/


                    /*val borderRound by animateIntAsState(targetValue = if (isRound) 100 else 0,
                        animationSpec = tween(
                            durationMillis = 3000,
                            delayMillis = 1000
                        )
                    )

                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.Red)
                            .clip(RoundedCornerShape(borderRound))
                    )*/

                    /*AnimatedVisibility(
                        visible = isVisible, modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Red)
                                .height(100.dp)
                        )
                    }*/

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Button(onClick = { isVisible = !isVisible }) {
                            Text(text = "Run Animation")
                        }
                        Button(onClick = { }) {
                            Text(text = "Next Animation")
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAnimationTheme {
        Greeting("Android")
    }
}