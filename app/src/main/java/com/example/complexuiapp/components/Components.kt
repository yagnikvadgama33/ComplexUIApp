package com.example.complexuiapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.complexuiapp.CvImageView
import com.example.complexuiapp.CvTextView
import com.example.complexuiapp.R
import com.example.complexuiapp.helper.sdp
import com.example.complexuiapp.helper.ssp
import com.example.complexuiapp.ui.theme.bgCalenderActiveColor
import com.example.complexuiapp.ui.theme.bgCalenderDeactiveColor
import com.example.complexuiapp.ui.theme.borderColor
import com.example.complexuiapp.ui.theme.headerTxtColor
import com.example.complexuiapp.ui.theme.productSansBold
import com.example.complexuiapp.ui.theme.productSansRegular
import com.example.complexuiapp.ui.theme.robotoMedium
import com.example.complexuiapp.ui.theme.robotoRegular
import com.example.complexuiapp.ui.theme.sfProDisplayBold
import com.example.complexuiapp.ui.theme.sfProDisplayRegular
import com.example.complexuiapp.ui.theme.subtitleTxtColor
import com.example.complexuiapp.ui.theme.wavwColor
import kotlin.math.PI
import kotlin.math.sin


@Composable
fun BearContent() {
    Row(
        modifier = Modifier
            .padding(vertical = 10.sdp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CvImageView(
            painter = R.drawable.ic_profile_pic,
            contentDes = "logo",
            modifier = Modifier
                .size(100.sdp)
                .padding(top = 2.sdp)
        )
        Column(
            modifier = Modifier.padding(horizontal = 12.sdp),
            verticalArrangement = Arrangement.Center
        ) {
            CvTextView(
                txt = stringResource(R.string.win_10_with_bober),
                style = sfProDisplayRegular,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.ssp
            )

            DotSeparatedList(
                listOf(
                    stringResource(R.string.lst_gaming),
                    stringResource(R.string.lst_airdrop),
                    stringResource(R.string.lst_nft)
                )
            )
        }
    }
}

@Composable
fun DotSeparatedList(items: List<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.sdp),
        modifier = Modifier.padding(top = 8.sdp)
    ) {
        items.forEachIndexed { index, item ->
            CvTextView(
                txt = item,
                fontSize = 14.ssp,
                textColor = subtitleTxtColor,
                style = robotoRegular,
                fontWeight = FontWeight.SemiBold
            )

            if (index != items.lastIndex) {
                CvTextView(
                    txt = "•",
                    fontSize = 14.ssp,
                    textColor = subtitleTxtColor,
                )
            }
        }
    }
}

@Composable
fun SocialMediaIcons(onClick: () -> Unit) {
    Box(
        modifier = Modifier.border(
            1.sdp, color = borderColor, shape = RoundedCornerShape(14.sdp)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.sdp, bottom = 14.sdp, start = 20.sdp, end = 6.sdp)
                .background(Color.White, shape = RoundedCornerShape(14.sdp)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f)
                    .padding(),
                horizontalArrangement = Arrangement.spacedBy(space = 22.sdp)
            ) {
                CvImageView(
                    painter = R.drawable.ic_internet, "internet", modifier = Modifier.size(24.sdp)
                )
                CvImageView(
                    painter = R.drawable.ic_x, "internet", modifier = Modifier.size(24.sdp)
                )
                CvImageView(
                    painter = R.drawable.ic_telegram, "internet", modifier = Modifier.size(24.sdp)
                )
                CvImageView(
                    painter = R.drawable.ic_mail, "internet", modifier = Modifier.size(24.sdp)
                )
            }
            CvImageView(
                painter = R.drawable.ic_3_plus,
                "internet",
                modifier = Modifier
                    .size(24.sdp)
                    .weight(0.13f)
                    .scale(1.3f)
                    .clickable(onClick = onClick)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun SocialLinksBottomSheet() {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(true) }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            containerColor = Color.White,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                // Title
                Text(
                    text = stringResource(R.string.social_links),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8A2BE2), // Purple color
                    modifier = Modifier.padding(bottom = 30.dp, start = 30.sdp)
                )

                // Grid Icons
                val icons = listOf(
                    Pair(R.drawable.ic_internet, "Facebook"),
                    Pair(R.drawable.ic_x, "Twitter"),
                    Pair(R.drawable.ic_telegram, "Telegram"),
                    Pair(R.drawable.ic_mail, "Coingeko"),
                    Pair(R.drawable.ic_internet, "Facebook"),
                    Pair(R.drawable.ic_x, "Twitter"),
                    Pair(R.drawable.ic_telegram, "Telegram"),
                )

                // 3x3 Grid Layout
                SocialLinksGrid(icons)
            }
        }
    }
}

@Composable
fun SocialLinksGrid(icons: List<Pair<Int, String>>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (rowIcons in icons.chunked(4)) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                rowIcons.forEach { (icon, label) ->
                    SocialLinkItem(icon = icon, label = label)
                }
            }
        }
    }
}

@Composable
fun SocialLinkItem(icon: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(80.dp)
            .clickable {

            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(60.dp)
                .background(Color(0xFFEFEFEF), RoundedCornerShape(12.dp))
        ) {
            CvImageView(
                painter = icon,
                contentDes = label,
                contextScale = ContentScale.Fit,
                modifier = Modifier.size(32.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        CvTextView(
            txt = label,
            fontSize = 12.sp,
            textColor = subtitleTxtColor,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun GradientBackground(setHeight: Float = 0.42f) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(setHeight)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF00C7D8), Color(0xFF23869A)
                    )
                )
            )
    )
}

@Composable
fun MiddleGradientBackground() {

    Box(
        modifier = Modifier
            .height(100.sdp)
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF23869A),
                        Color.Transparent,
                    )
                )
            )
    )
}

@Composable
fun ExpandableText(
    text: String,
    modifier: Modifier = Modifier,
    minimizedMaxLines: Int = 3,
    readMoreText: String = "...Read More"
) {
    var expanded by remember { mutableStateOf(false) }
    var cutText by remember { mutableStateOf<String?>(null) }
    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    val seeMoreSizeState = remember { mutableStateOf<IntSize?>(null) }
    val seeMoreOffsetState = remember { mutableStateOf<Offset?>(null) }

    val textLayoutResult = textLayoutResultState.value
    val seeMoreSize = seeMoreSizeState.value

    LaunchedEffect(text, expanded, textLayoutResult, seeMoreSize) {
        val lastLineIndex = minimizedMaxLines - 1
        if (!expanded && textLayoutResult != null && seeMoreSize != null && lastLineIndex + 1 == textLayoutResult.lineCount && textLayoutResult.isLineEllipsized(
                lastLineIndex
            )
        ) {
            var lastCharIndex = textLayoutResult.getLineEnd(lastLineIndex, visibleEnd = true) + 1
            var charRect: Rect
            do {
                lastCharIndex -= 1
                charRect = textLayoutResult.getCursorRect(lastCharIndex)
            } while (charRect.left > textLayoutResult.size.width - seeMoreSize.width)
            seeMoreOffsetState.value = Offset(charRect.left, charRect.bottom - seeMoreSize.height)
            cutText = text.substring(startIndex = 0, endIndex = lastCharIndex)
        }
    }

    Text(text = if (!expanded && cutText != null) {
        buildAnnotatedString {
            append(cutText ?: "")
            append(" ")
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                append(readMoreText)
            }
        }
    } else {
        AnnotatedString(text)
    },
        maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = { textLayoutResultState.value = it },
        modifier = modifier.clickable {
            expanded = !expanded
            if (!expanded) cutText = null
        },
        style = robotoRegular,
        color = headerTxtColor,
        fontSize = 13.ssp
    )
}

@Composable
fun WavyCanvasView() {
    val waveHeight = 10f
    val waveLength = 60f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .background(Color.White)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val width = size.width
            val height = size.height

            val wavePath = Path().apply {
                moveTo(0f, waveHeight)

                // Top wave
                var x = 0f
                while (x < width) {
                    val y = waveHeight * sin((1 * PI * x / waveLength)).toFloat()
                    lineTo(x, waveHeight + y)
                    x += 1f
                }

                lineTo(width, height - waveHeight)

                // Bottom wave
                x = width
                while (x > 0) {
                    val y = waveHeight * sin((1 * PI * x / waveLength)).toFloat()
                    lineTo(x, height - waveHeight + y)
                    x -= 1f
                }

                close()
            }

            drawPath(
                path = wavePath, color = wavwColor
            )
        }
    }
}

@Composable
fun WaveItems() {
    Column(
        modifier = Modifier
            .width(135.sdp)
            .height(160.sdp)
            .padding(8.sdp)
            .background(
                Color.White, shape = RoundedCornerShape(12.sdp)
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(12.sdp))

        CvImageView(
            painter = R.drawable.ic_nft, contentDes = "ntf icon"
        )
        Spacer(Modifier.height(14.sdp))

        CvTextView(
            txt = stringResource(R.string._350_nft_s),
            fontSize = 16.ssp,
            style = sfProDisplayRegular,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(8.sdp))

        CvTextView(
            txt = "To be won during this airdrop",
            fontSize = 12.ssp,
            style = robotoRegular,
            textColor = subtitleTxtColor,
            modifier = Modifier.padding(horizontal = 3.sdp),
            textAlign = TextAlign.Center,
            letterSpacing = TextUnit(0.2f, TextUnitType.Sp)
        )
    }
}

@Composable
fun AirdropTimeline() {
    Column {

        // "Airdrop Timeline" Title Text
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CvImageView(
                painter = R.drawable.ic_airdrop_timline,
                contentDes = "airdrop timeline",
                modifier = Modifier
                    .rotate(180f)
                    .padding(horizontal = 8.sdp)
                    .align(Alignment.CenterVertically)
            )

            CvTextView(
                txt = stringResource(R.string.airdrop_timeline),
                modifier = Modifier
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithCache {
                        val brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xFF8B37F7), Color(0xFFFA8662)
                            )
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                        }
                    },
                fontSize = 21.ssp,
                style = sfProDisplayBold
            )

            CvImageView(
                painter = R.drawable.ic_airdrop_timline,
                contentDes = "airdrop timeline",
                modifier = Modifier
                    .padding(horizontal = 12.sdp)
                    .align(Alignment.CenterVertically)
            )
        }

        Spacer(Modifier.height(16.sdp))

        //Calender View's
        Row(
            modifier = Modifier.padding(start = 14.sdp)
        ) {
            CalendarCard("09", "Apr, 24", "Airdrop and tasks launch", bgCalenderDeactiveColor)
            CalendarCard("09", "Apr, 24", "Airdrop and tasks launch", bgCalenderActiveColor)
        }
    }
}

@Composable
fun CalendarCard(day: String, monthAndYear: String, descText: String, bgColor: Color) {

    val cornerRadius = 20.sdp

    Column(
        modifier = Modifier
            .height(144.sdp)
            .width(120.sdp)
            .padding(vertical = 18.sdp)
            .background(bgColor, shape = RoundedCornerShape(cornerRadius)),
    )
    {

        Row {
            CvTextView(
                txt = day,
                style = productSansBold,
                textColor = Color.White,
                fontSize = 32.ssp,
                modifier = Modifier.padding(start = 20.sdp, top = 20.sdp)
            )

            CvTextView(
                txt = monthAndYear,
                style = robotoRegular,
                textColor = Color.White,
                fontSize = 12.ssp,
                modifier = Modifier
                    .padding(start = 5.sdp, bottom = 6.sdp)
                    .align(Alignment.Bottom),
                textAlign = TextAlign.Start
            )
        }

        //Desc Text with white bg
        Box(
            modifier = Modifier
                .padding(end = 3.sdp, start = 1.sdp, bottom = 3.sdp)
                .fillMaxWidth()
                .height(56.sdp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(bottomEnd = cornerRadius, bottomStart = cornerRadius)
                )
        ) {

            CvTextView(
                txt = descText,
                textColor = headerTxtColor,
                fontSize = 13.ssp,
                textAlign = TextAlign.Center,
                style = robotoMedium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 16.sdp)
            )
        }
    }


    //2nd Hook
    Box(Modifier.offset(x = ((-48).sdp), y = ((9).sdp))) {
        CvImageView(painter = R.drawable.ic_hook, contentDes = stringResource(R.string.hook))
    }

    //1st Hook
    Box(Modifier.offset(x = ((-110).sdp), y = ((9).sdp))) {
        CvImageView(painter = R.drawable.ic_hook, contentDes = stringResource(R.string.hook))
    }
}
