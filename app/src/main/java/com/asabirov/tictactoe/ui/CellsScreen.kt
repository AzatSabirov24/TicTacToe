package com.asabirov.tictactoe.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp

@Composable
fun CellsScreen() {
    val animateLine = remember {
        Animatable(initialValue = 0f)
    }
    val animateLineHorizontal = remember {
        Animatable(initialValue = 0f)
    }
    var center by remember {
        mutableStateOf(Offset.Unspecified)
    }
    LaunchedEffect(key1 = true) {
        animateLine.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearEasing
            )
        )
    }
    LaunchedEffect(key1 = true) {
        animateLineHorizontal.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 300,
                delayMillis = 300,
                easing = LinearEasing
            )
        )
    }
    val verticalPath = Path().apply {
        moveTo(-100f, -300f)
        lineTo(-100f, 300f)
    }
    val verticalPath2 = Path().apply {
        moveTo(100f, -300f)
        lineTo(100f, 300f)
    }
    val horizontalPath = Path().apply {
        moveTo(-300f, -100f)
        lineTo(300f, -100f)
    }
    val horizontalPath2 = Path().apply {
        moveTo(-300f, 100f)
        lineTo(300f, 100f)
    }
    val verticalOutPath = Path()
    val verticalOutPath2 = Path()
    val horizontalOutPath = Path()
    val horizontalOutPath2 = Path()
    PathMeasure().apply {
        setPath(verticalPath, false)
        getSegment(0f, animateLine.value * length, verticalOutPath, true)
    }
    PathMeasure().apply {
        setPath(verticalPath2, false)
        getSegment(0f, animateLine.value * length, verticalOutPath2, true)
    }
    PathMeasure().apply {
        setPath(horizontalPath, false)
        getSegment(0f, animateLineHorizontal.value * length, horizontalOutPath, true)
    }
    PathMeasure().apply {
        setPath(horizontalPath2, false)
        getSegment(0f, animateLineHorizontal.value * length, horizontalOutPath2, true)
    }
    Canvas(modifier = Modifier.fillMaxSize()) {
        center = this.center
        drawIntoCanvas {
            translate(center.x, center.y) {
                drawPath(
                    path = verticalOutPath,
                    color = Color.Black,
                    style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
                )
                drawPath(
                    path = verticalOutPath2,
                    color = Color.Black,
                    style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
                )
                drawPath(
                    path = horizontalOutPath,
                    color = Color.Black,
                    style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
                )
                drawPath(
                    path = horizontalOutPath2,
                    color = Color.Black,
                    style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
                )
            }
        }
    }
}