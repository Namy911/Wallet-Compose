package com.example.walletcompose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletcompose.R
import com.example.walletcompose.ui.theme.ButtonNextColor
import com.example.walletcompose.ui.theme.Primary


@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp, start = 16.dp, end = 16.dp),
    ) {
        EditableTextField()
        PasswordFieldWithToggle()
        ButtonGreen("Login")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "New To Wpay? ",
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    color = Color.Gray,
                )
            )

            val style = SpanStyle(
                color = Primary,
                fontWeight = FontWeight.ExtraBold,
                textDecoration = TextDecoration.Underline,
                fontSize = 18.sp
            )
            ClickableText(value = "Sign Up", style = style)
        }
        Spacer(modifier = Modifier.padding(36.dp))

        ButtonWithIcon(
            text = "Login with Facebook",
            resourceId = R.drawable.facebook
        )
        Spacer(modifier = Modifier.padding(8.dp))
        ButtonWithIcon(
            text = "Login with Google",
            resourceId = R.drawable.google
        )

    }
    DrawLogo(modifier = Modifier.offset(x = (-12).dp, y = 16.dp), color = Color.Gray, isCenterVertical = false)
}

@Composable
fun PasswordFieldWithToggle() {
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                val icon = if (isPasswordVisible) {
                    painterResource(id = R.drawable.eye_show)
                } else {
                    painterResource(id = R.drawable.eye_hide)
                }
                Icon(painter = icon, contentDescription = "Toggle password visibility")
            }
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth().padding(16.dp),
    )
}

@Composable
fun EditableTextField() {
    var email by remember { mutableStateOf("") }

    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Your Email") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth().padding(16.dp),
    )
}


