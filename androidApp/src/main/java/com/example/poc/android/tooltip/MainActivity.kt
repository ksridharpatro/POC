package com.example.poc.android.tooltip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.poc.android.MyApplicationTheme
import com.example.poc.android.R
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.skydoves.balloon.compose.setBackgroundColor
import com.skydoves.balloon.compose.setOverlayColor
import com.skydoves.balloon.overlay.BalloonOverlayRoundRect

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Screen()
            }
        }
    }

    @Preview
    @Composable
    fun Screen() {
        val builder = rememberBalloonBuilder {
            setArrowSize(10)
            setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            setArrowPosition(0.5f)
            setWidth(BalloonSizeSpec.WRAP)
            setHeight(BalloonSizeSpec.WRAP)
            setPadding(12)
            setCornerRadius(8f)
            setBackgroundColor(Color.Cyan)
            setIsVisibleOverlay(true)
            setOverlayColor(Color.Gray)
            setOverlayPaddingResource(R.dimen.editBalloonOverlayPadding)
            setOverlayShape(
                BalloonOverlayRoundRect(
                    R.dimen.editBalloonOverlayRadius,
                    R.dimen.editBalloonOverlayRadius
                )
            )
            setDismissWhenClicked(false)
        }
        var okPressed by remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxSize()) {
            Balloon(
                modifier = Modifier.align(Alignment.Center),
                builder = builder,
                balloonContent = {
                    Column {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Now you can edit your profile!",
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                        Button(onClick = { okPressed = true }) {
                            Text(text = "OK")
                        }
                    }
                }
            ) { balloonWindow ->
                Button(
                    modifier = Modifier.size(160.dp, 60.dp),
                    onClick = { balloonWindow.showAlignTop() }
                ) {
                    Text(text = "showAlignTop")
                }
                LaunchedEffect(key1 = okPressed) {
                    if (okPressed) {
                        balloonWindow.dismiss()
                    }
                }

                LaunchedEffect(key1 = Unit) {
                    balloonWindow.setOnBalloonDismissListener {
                        okPressed = false
                    }
                }
            }
        }
    }
}
