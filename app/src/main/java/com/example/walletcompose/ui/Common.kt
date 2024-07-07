package com.example.walletcompose.ui

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletcompose.R
import com.example.walletcompose.ui.theme.ButtonNextColor
import com.example.walletcompose.ui.theme.MainCardColor
import com.example.walletcompose.ui.theme.SecondCardColor
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

@Composable
fun getDrawableResourceId(context: Context, resourceName: String): Int {
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

@Composable
fun DrawLogo(modifier: Modifier, color: Color = Color.White, isCenterVertical: Boolean = true) {
    DrawHorizontalLineAtCenterBottom(color)
    DrawInclinedRectangle(SecondCardColor, isCenterVertical)
    Box(modifier = modifier) {
        DrawInclinedRectangle(MainCardColor, isCenterVertical)
    }
}

@Composable
fun DrawInclinedRectangle(color: Color, isCenterVertical: Boolean) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val rectangleWidth = 150.dp
    val rectangleHeight = 75.dp
    var centerX = 0.dp
    var centerY = 0.dp

    if (isCenterVertical) {
        centerX = (screenWidth - rectangleWidth) / 2
        centerY = (screenHeight - rectangleHeight) / 2
    } else {
        centerX = ((screenWidth - rectangleWidth) / 2) + 16.dp
        centerY = (16.dp + rectangleHeight)
    }

    val name = stringResource(id = R.string.company_name)

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawIntoCanvas { canvas ->
            rotate(-6F) {
                drawRoundRect(
                    color = color,
                    topLeft = Offset(centerX.toPx(), centerY.toPx()),
                    size = Size(rectangleWidth.toPx(), rectangleHeight.toPx()),
                    cornerRadius = CornerRadius(36F),
                )

                val paint = createPaint(
                    color = Color.White,
                    fontSize = 36.sp.value,
                    fontWeight = FontWeight.Bold
                )
                val textCenterX = centerX.toPx() + ((rectangleWidth / 2) - 16.dp).toPx()
                val textCenterY = centerY.toPx() + ((rectangleHeight / 2) + 4.dp).toPx()

                canvas.nativeCanvas.drawText(
                    name, textCenterX, textCenterY, paint
                )
            }
        }
    }
}

@Composable
fun DrawHorizontalLineAtCenterBottom(color: Color) {
    val configuration = LocalConfiguration.current
    val lineWidth = configuration.screenWidthDp.dp.value
    val marginBottom = 48

    Canvas(modifier = Modifier.height(25.dp).fillMaxWidth()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val startX = (canvasWidth - lineWidth) / 2
        val startY = canvasHeight - marginBottom
        val endX = startX + lineWidth

        drawLine(
            color = color,
            start = Offset(startX, startY),
            end = Offset(endX, startY),
            strokeWidth = 12f,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun ButtonGreen(text: String, onClick: () -> Unit = { }) {
    Button(
        modifier = Modifier.fillMaxWidth().padding(end = 16.dp, start = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(ButtonNextColor),
        onClick = { }) {
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun ButtonWithIcon(text: String, resourceId: Int, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(2.dp, Color.Gray),
        colors = ButtonDefaults.buttonColors(
            contentColor = SecondCardColor
        ),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val icon = painterResource(id = resourceId)
            Icon(painter = icon, contentDescription = "null")
            Spacer(modifier = Modifier.weight(1F))
            Text(
                text = text,
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                ),
            )
            Spacer(modifier = Modifier.weight(1F))
        }
    }
}

@Composable
fun ClickableText(value: String, style: SpanStyle, annotation: String = "", tag: String = "URL") {
    val text = AnnotatedString.Builder(value)
        .apply {
            addStyle(
                style = style,
                start = 0,
                end = value.length,
            )
            addStringAnnotation(
                tag = tag,
                annotation = annotation,
                start = 0,
                end = value.length
            )
        }
        .toAnnotatedString()

    ClickableText(
        text = text,
        modifier = Modifier,
        onClick = {
            println("Clicked on: https://www.example.com")
        }
    )
}

