package com.example.walletcompose.ui

import android.content.Context
import androidx.compose.ui.graphics.Color
import android.graphics.Paint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

fun createPaint(color: Color, fontSize: Float, fontWeight: FontWeight): Paint {
    val paint = Paint().apply {
        this.color = color.toArgb()
        textSize = fontSize
        isFakeBoldText = true
    }
    return paint
}

