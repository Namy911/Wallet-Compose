package com.example.walletcompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.walletcompose.R

private const val PAGE_COUNT = 3
private const val INITIAL_PAGE = 0

@Composable
fun OnBoardingScreen(){
    HorizontalPagerWithIndicators()
    ButtonSkip()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithIndicators() {
    val pagerState = rememberPagerState(initialPage = INITIAL_PAGE) { PAGE_COUNT }
    var selectedPage by remember { mutableIntStateOf(pagerState.currentPage) }

    LaunchedEffect(pagerState) {
        selectedPage = pagerState.currentPage
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
        ) {
            HorizontalPager(
                state = pagerState,
            ) { currPage ->
                when (currPage) {
                    0 -> ScreenOne()
                    1 -> ScreenTwo()
                    2 -> ScreenOThree()
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape( topEnd = 24.dp, topStart = 24.dp)
                ),
        ) {
            BottomShit()
        }
    }
    DrawHorizontalLineAtCenterBottom(color = Color.Gray)
}

@Composable
fun ScreenOne() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 15.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(9f)
        ) {
            PageImage("qr_code")
        }
        Row(
            modifier = Modifier.fillMaxSize().weight(1F),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
        ) {
            ImageAtBottom("group_147")
            ImageAtBottom("ellipse_11")
            ImageAtBottom("ellipse_12")
        }
    }
}

@Composable
fun ScreenTwo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 15.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
        ) {
            ImageAtBottom("ellipse_11")
            ImageAtBottom("group_147")
            ImageAtBottom("ellipse_12")
        }
    }
}

@Composable
fun ScreenOThree() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
        ) {
            ImageAtBottom("ellipse_11")
            ImageAtBottom("ellipse_12")
            ImageAtBottom("group_147")
        }
    }
}

@Composable
fun ImageAtBottom(resourceName: String) {
    val context = LocalContext.current
    val resourceId = getDrawableResourceId(context, resourceName)

    Image(
        modifier = Modifier.padding(5.dp),
        painter = painterResource(id = resourceId),
        contentDescription = null
    )
}

@Composable
fun PageImage(resourceName: String) {
    val context = LocalContext.current
    val resourceId = getDrawableResourceId(context, resourceName)

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = resourceId),
        contentDescription = null
    )
}

@Composable
fun BottomShit() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.fastest_payment),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                text = stringResource(R.string.message_qr_code_onbording),
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                ),
            )
            ButtonGreen(
                stringResource(R.string.btn_next)
            )
        }
    }
}

@Composable
fun ButtonSkip(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd) {
        Button(
            modifier = Modifier.wrapContentSize(),
            onClick = { }) {
            Text(
                text = stringResource(R.string.btn_skip),
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    color = Color.White,
                )
            )
        }
    }
}




