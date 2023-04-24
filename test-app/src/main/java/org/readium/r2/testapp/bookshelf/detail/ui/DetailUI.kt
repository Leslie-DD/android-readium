package org.readium.r2.testapp.bookshelf.detail.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import org.readium.r2.testapp.R

@Composable
public fun BookDetailScreen() {

}

@Preview(widthDp = 500, heightDp = 300)
@Composable
fun CircleRing(
//    viewModel: TaskViewModel
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

        Image(
            painter = painterResource(id = R.drawable.book_cover),
            contentDescription = "book background blur pic",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    radiusX = 150.dp,
                    radiusY = 150.dp,
                )
        )

        var toggleState by remember { mutableStateOf(true) }
        val rate: Float by animateFloatAsState(
            if (toggleState) 0.1f else 0.8f,
            animationSpec = tween(durationMillis = 1000)
        )

        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Card(
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Image(
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(200.dp),
                        painter = painterResource(id = R.drawable.book_cover),
                        contentDescription = "book_cover",
                    )
                }
                CircularProgress(rate)
            }

            Button(
                onClick = { toggleState = !toggleState }
            ) {
                Text(text = "reset")
            }
        }
    }
}

/**
 * @param rate 0 ~ 1
 */
@Composable
fun CircularProgress(rate: Float) {
    Canvas(
        modifier = Modifier.size(200.dp),
        onDraw = {
            val strokeWidth = 10.dp.toPx()
            drawArc(
                Color(0, 0, 0, 15),
                startAngle = 160f,
                sweepAngle = -140f,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
            )
            drawArc(
                brush = Brush.sweepGradient( // !!! that what
                    0f to Color(0x00EF7B7B),
                    0.9f to Color(0xFFEF7B7B),
                    0.91f to Color(0x00EF7B7B), // there was a problem with start of the gradient, maybe there way to solve it better
                    1f to Color(0x00EF7B7B)
                ),
                startAngle = 160f,
                sweepAngle = -rate * 140,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
            )
        }
    )
}

class IntProvider : PreviewParameterProvider<Int> {
    override val values: Sequence<Int>
        get() = listOf(1, 2).asSequence()
}