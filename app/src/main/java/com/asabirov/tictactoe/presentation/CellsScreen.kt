package com.asabirov.tictactoe.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun CellsScreen(modifier: Modifier) {
    val animateLineVertical = remember {
        Animatable(initialValue = 0f)
    }
    val animateLineHorizontal = remember {
        Animatable(initialValue = 0f)
    }
    val tappedOffset = remember {
        mutableStateOf(Offset.Zero)
    }
    LaunchedEffect(key1 = true) {
        animateLineVertical.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 300
            )
        )
    }
    LaunchedEffect(key1 = true) {
        animateLineHorizontal.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 300,
                delayMillis = 300
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
    val clickedCellDetector = ClickedCellDetector()
    PathMeasure().apply {
        setPath(verticalPath, false)
        getSegment(0f, animateLineVertical.value * length, verticalOutPath, true)
    }
    PathMeasure().apply {
        setPath(verticalPath2, false)
        getSegment(0f, animateLineVertical.value * length, verticalOutPath2, true)
    }
    PathMeasure().apply {
        setPath(horizontalPath, false)
        getSegment(0f, animateLineHorizontal.value * length, horizontalOutPath, true)
    }
    PathMeasure().apply {
        setPath(horizontalPath2, false)
        getSegment(0f, animateLineHorizontal.value * length, horizontalOutPath2, true)
    }
    Canvas(modifier = modifier
        .fillMaxSize()
        .pointerInput(true) {
            detectTapGestures {
                tappedOffset.value = it
            }
        }
    ) {
        translate(center.x, center.y) {
//            println("qqq ->CellsScreen->center.x= ${center.x}")
//            println("qqq ->CellsScreen->tappedX.value.x = ${tappedX.value.x}")
//            println("qqq ->CellsScreen->center.x - tappedX.value.x= ${center.x - tappedX.value.x}")
//            println("qqq ->CellsScreen->center.x= ${center.y}")
//            println("qqq ->CellsScreen->tappedX.value.y = ${tappedX.value.y}")
//            println("qqq ->CellsScreen->center.y - tappedX.value.y= ${center.y - tappedX.value.y}")
            val cellType =
                clickedCellDetector(center.x - tappedOffset.value.x, center.y - tappedOffset.value.y)
//            println("qqq ->clickDetector= $cellType")

            detectCellCenter(cellType)?.let {
                drawCircle(
                    color = Color.Red,
                    radius = 10.dp.toPx(),
                    center = it
                )
            }
            drawPath(
                path = verticalOutPath,
                color = Color.Black,
                style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
            )
            drawPath(
                path = verticalOutPath2,
                color = Color.Black,
                style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
            )
            drawPath(
                path = horizontalOutPath,
                color = Color.Black,
                style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
            )
            drawPath(
                path = horizontalOutPath2,
                color = Color.Black,
                style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
            )
        }
    }
}

fun detectCellCenter(cellType: CellType): Offset? {
    return when (cellType) {
        is CellType.FirstCellType -> {
            Offset(
                x = -200f,
                y = -200f
            )
        }

        is CellType.SecondCellType ->
            Offset(
                x = 0f,
                y = -200f
            )

        is CellType.ThirdCellType ->
            Offset(
                x = 200f,
                y = -200f
            )


        is CellType.ForthCellType ->
            Offset(
                x = -200f,
                y = 0f
            )


        is CellType.FifthCellType ->
            Offset(
                x = 0f,
                y = 0f
            )


        is CellType.SixthCellType ->
            Offset(
                x = 200f,
                y = 0f
            )


        is CellType.SeventhCellType ->
            Offset(
                x = -200f,
                y = 200f
            )


        is CellType.EighthCellType ->
            Offset(
                x = 0f,
                y = 200f
            )


        is CellType.NinthCellType ->
            Offset(
                x = 200f,
                y = 200f
            )
        else -> null
    }
}