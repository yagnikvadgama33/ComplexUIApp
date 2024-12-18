package com.example.complexuiapp.components

import android.os.CountDownTimer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.complexuiapp.CvImageView
import com.example.complexuiapp.CvTextView
import com.example.complexuiapp.R
import com.example.complexuiapp.helper.CalenderView
import com.example.complexuiapp.helper.NtfItems
import com.example.complexuiapp.helper.sdp
import com.example.complexuiapp.helper.ssp
import com.example.complexuiapp.ui.theme.bgCalenderActiveColor
import com.example.complexuiapp.ui.theme.bgCalenderDeactiveColor
import com.example.complexuiapp.ui.theme.borderColor
import com.example.complexuiapp.ui.theme.bulletPointColor
import com.example.complexuiapp.ui.theme.headerTxtColor
import com.example.complexuiapp.ui.theme.lineColor
import com.example.complexuiapp.ui.theme.liteGreyColor
import com.example.complexuiapp.ui.theme.moreIconColor
import com.example.complexuiapp.ui.theme.productSansBold
import com.example.complexuiapp.ui.theme.productSansMedium
import com.example.complexuiapp.ui.theme.productSansRegular
import com.example.complexuiapp.ui.theme.purperTextColor
import com.example.complexuiapp.ui.theme.purpleBgColor
import com.example.complexuiapp.ui.theme.purpleColor
import com.example.complexuiapp.ui.theme.robotoBold
import com.example.complexuiapp.ui.theme.robotoMedium
import com.example.complexuiapp.ui.theme.robotoRegular
import com.example.complexuiapp.ui.theme.sfProDisplayBold
import com.example.complexuiapp.ui.theme.sfProDisplayRegular
import com.example.complexuiapp.ui.theme.sfProDisplaySemiBold
import com.example.complexuiapp.ui.theme.subtitleTxtColor
import com.example.complexuiapp.ui.theme.txtPinkColor
import com.example.complexuiapp.ui.theme.unselectedTextColor
import com.example.complexuiapp.ui.theme.wavwColor
import kotlin.math.PI
import kotlin.math.roundToInt
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
                .size(80.sdp)
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
                fontSize = 12.ssp,
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
fun SocialMediaIcons() {

    val icons = listOf(
        Pair(R.drawable.ic_internet, "Facebook"),
        Pair(R.drawable.ic_x, "Twitter"),
        Pair(R.drawable.ic_telegram, "Telegram")
    )

    Box(
        modifier = Modifier.border(
            1.sdp, color = borderColor, shape = RoundedCornerShape(14.sdp)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.sdp, bottom = 8.sdp, start = 20.sdp, end = 6.sdp)
                .background(Color.White, shape = RoundedCornerShape(14.sdp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.8f),
                horizontalArrangement = if (icons.size <= 4) Arrangement.spacedBy(
                    26.sdp,
                    Alignment.CenterHorizontally
                ) else Arrangement.spacedBy(18.sdp, Alignment.Start)
            ) {

                icons.forEachIndexed { index, (icon, label) ->
                    if (index < 4) {
                        CvImageView(
                            painter = icon, label, modifier = Modifier.size(24.sdp)
                        )
                    }
                }
            }
            if (icons.size > 4) {
                MoreSocialIconsView(icons.size - 4, Modifier.weight(0.17f))
            }
        }
    }
}

@Composable
fun MoreSocialIconsView(iconNum: Int, modifier: Modifier) {
    Box(
        modifier = modifier
            .background(liteGreyColor, RoundedCornerShape(8.sdp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 6.sdp, horizontal = 3.sdp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CvTextView(
                txt = if (iconNum > 9) stringResource(R.string._9) else stringResource(
                    R.string.icon_cont,
                    iconNum
                ),
                style = productSansMedium,
                fontSize = 14.ssp,
                textColor = moreIconColor
            )
            CvImageView(
                painter = R.drawable.ic_more_icons,
                contentDes = stringResource(R.string.more_icons),
                modifier = Modifier.padding(start = 6.sdp)
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
                Modifier.fillMaxWidth()
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
                horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()
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
    val interactionSource = remember { MutableInteractionSource() }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(80.dp)
            .clickable(
                interactionSource = interactionSource, indication = null
            ) {}) {
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
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    text: String,
    collapsedMaxLine: Int = 3,
    showMoreText: String = stringResource(R.string.read_more),
    showMoreStyle: SpanStyle = SpanStyle(
        fontWeight = FontWeight.Bold, brush = Brush.linearGradient(
            colors = listOf(Color(0xFFFA8662), Color(0xFF8B37F7)), tileMode = TileMode.Repeated
        )
    )
) {
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableStateOf(0) }

    val interactionSource = remember { MutableInteractionSource() }

    Box(modifier = Modifier
        .clickable(
            interactionSource = interactionSource, indication = null, enabled = clickable
        ) {
            isExpanded = !isExpanded
        }
        .then(modifier)) {

        Text(
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        append(text)
                    } else {
                        val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLast(showMoreText.length)
                            .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                        append("$adjustText...")
                        withStyle(style = showMoreStyle) { append(showMoreText) }
                    }
                } else {
                    append(text)
                }
            },
            modifier = textModifier
                .fillMaxWidth()
                .animateContentSize(),
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = textLayoutResult.getLineEnd(collapsedMaxLine - 1)
                }
            },
            style = robotoRegular,
            fontSize = 13.ssp
        )
    }
}

@Composable
fun WavyCanvasView() {
    val waveHeight = 10f
    val waveLength = 60f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
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

    val nftItems = listOf(
        NtfItems(
            R.drawable.ic_nft,
            stringResource(R.string._350_nft_s),
            stringResource(R.string.to_be_won_during_this_airdrop)
        ),
        NtfItems(
            R.drawable.ic_nft,
            stringResource(R.string._350_nft_s),
            stringResource(R.string.to_be_won_during_this_airdrop)
        ),
        NtfItems(
            R.drawable.ic_nft,
            stringResource(R.string._350_nft_s),
            stringResource(R.string.to_be_won_during_this_airdrop)
        ),
        NtfItems(
            R.drawable.ic_nft,
            stringResource(R.string._350_nft_s),
            stringResource(R.string.to_be_won_during_this_airdrop)
        )
    )

    Row(
        modifier = Modifier
            .padding(start = 14.sdp)
            .horizontalScroll(state = ScrollState(0)),
        horizontalArrangement = Arrangement.Start
    ) {
        nftItems.forEach {
            Column(
                modifier = Modifier
                    .width(125.sdp)
                    .height(150.sdp)
                    .padding(vertical = 8.sdp, horizontal = 5.sdp)
                    .background(
                        Color.White, shape = RoundedCornerShape(12.sdp)
                    ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(6.sdp))

                CvImageView(
                    painter = it.icon, contentDes = stringResource(R.string.ntf_icon)
                )
                Spacer(Modifier.height(8.sdp))

                CvTextView(
                    txt = it.title,
                    fontSize = 16.ssp,
                    style = sfProDisplayRegular,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.sdp))

                CvTextView(
                    txt = it.description,
                    fontSize = 12.ssp,
                    style = robotoRegular,
                    textColor = subtitleTxtColor,
                    modifier = Modifier.padding(horizontal = 6.sdp),
                    textAlign = TextAlign.Center,
                    letterSpacing = TextUnit(0.2f, TextUnitType.Sp)
                )
            }
        }
    }

    /*Column(
        modifier = Modifier
            .width(130.sdp)
            .height(155.sdp)
            .padding(8.sdp)
            .background(
                Color.White, shape = RoundedCornerShape(12.sdp)
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(8.sdp))

        CvImageView(
            painter = R.drawable.ic_nft, contentDes = stringResource(R.string.ntf_icon)
        )
        Spacer(Modifier.height(12.sdp))

        CvTextView(
            txt = stringResource(R.string._350_nft_s),
            fontSize = 16.ssp,
            style = sfProDisplayRegular,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(8.sdp))

        CvTextView(
            txt = stringResource(R.string.to_be_won_during_this_airdrop),
            fontSize = 12.ssp,
            style = robotoRegular,
            textColor = subtitleTxtColor,
            modifier = Modifier.padding(horizontal = 3.sdp),
            textAlign = TextAlign.Center,
            letterSpacing = TextUnit(0.2f, TextUnitType.Sp)
        )
    }*/
}

@Composable
fun GradiantTitleText(strTitle: String) {
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
            txt = strTitle, modifier = Modifier
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
                }, fontSize = 21.ssp, style = sfProDisplayBold
        )

        CvImageView(
            painter = R.drawable.ic_airdrop_timline,
            contentDes = "airdrop timeline",
            modifier = Modifier
                .padding(horizontal = 12.sdp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun AirdropTimeline(strTitle: String) {

    val calenderItemList = listOf(
        CalenderView(
            day = 9,
            monthAndYear = stringResource(R.string.apr_24),
            remark = stringResource(R.string.airdrop_and_tasks_launch),
            bgColor = bgCalenderDeactiveColor,
            isSingleDigit = true
        ),
        CalenderView(
            15,
            stringResource(R.string.apr_24),
            stringResource(R.string.start_of_ticket_sale),
            bgCalenderActiveColor,
            isSingleDigit = false
        ),
        CalenderView(
            21,
            stringResource(R.string.apr_24),
            stringResource(R.string.ticket_sale_closing),
            bgCalenderDeactiveColor,
            isSingleDigit = false
        ),
        CalenderView(
            day = 9,
            monthAndYear = stringResource(R.string.apr_24),
            remark = stringResource(R.string.airdrop_and_tasks_launch),
            bgColor = bgCalenderDeactiveColor,
            isSingleDigit = true
        )
    )

    Column {
        // "Airdrop Timeline" Title Text
        GradiantTitleText(strTitle)
        Spacer(Modifier.height(36.sdp))

        //Calender View's
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(state = ScrollState(0))
        ) {

            calenderItemList.forEach {
                NewCalenderView(
                    it.day, it.monthAndYear, it.remark, it.bgColor, it.isSingleDigit
                )
            }
        }
    }
}

@Composable
fun NewCalenderView(
    day: Int, monthAndYear: String, descText: String, bgColor: Color, isSingleDigit: Boolean
) {

    val roundedCornerRadius = 22.sdp

    Box(
        modifier = Modifier
            .height(115.sdp)
            .width(137.sdp)
            .padding(start = 14.sdp)
            .background(bgCalenderDeactiveColor, shape = RoundedCornerShape(roundedCornerRadius))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 3.sdp)
                .background(
                    bgCalenderDeactiveColor, shape = RoundedCornerShape(roundedCornerRadius)
                )
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            bgColor, shape = RoundedCornerShape(
                                topStart = roundedCornerRadius, topEnd = roundedCornerRadius
                            )
                        )
                ) {
                    CvTextView(
                        txt = if (isSingleDigit) "0$day" else day.toString(),
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
                        .fillMaxSize()
                        .padding(start = 1.sdp, bottom = 3.sdp)
                        .background(
                            Color.White, shape = RoundedCornerShape(
                                bottomEnd = roundedCornerRadius, bottomStart = roundedCornerRadius
                            )
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
        }

        //1st Hook
        Box(Modifier.offset(x = ((-107).sdp), y = ((-9).sdp))) {
            CvImageView(painter = R.drawable.ic_hook, contentDes = stringResource(R.string.hook))
        }

        //2nd Hook
        Box(Modifier.offset(x = ((-59).sdp), y = ((-9).sdp))) {
            CvImageView(painter = R.drawable.ic_hook, contentDes = stringResource(R.string.hook))
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
    ) {
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

@Composable
fun EarnMoreXifiPointsHeader() {
    Row(
        modifier = Modifier.paint(painter = painterResource(R.drawable.horizantle_gradeant)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CvImageView(
            painter = R.drawable.ic_double_down_arrow,
            contentDes = stringResource(R.string.down_arrows),
            modifier = Modifier.padding(start = 20.sdp)
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CvTextView(
                txt = stringResource(R.string.do_this_tasks),
                style = sfProDisplayRegular,
                fontSize = 14.ssp,
                textAlign = TextAlign.Center,
                textColor = headerTxtColor
            )

            CvTextView(
                txt = stringResource(R.string.and_earn_more_ixfi_points),
                style = sfProDisplayBold,
                textColor = headerTxtColor,
                fontSize = 20.ssp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 6.sdp)
            )
        }

        CvImageView(
            painter = R.drawable.ic_double_down_arrow,
            contentDes = stringResource(R.string.down_arrows),
            modifier = Modifier.padding(end = 20.sdp)
        )
    }
}

@Composable
fun EarmMorePointsTask() {

    val taskList = listOf(
        Pair(R.drawable.ic_kyc, stringResource(R.string.kyc_task_image)),
        Pair(R.drawable.ic_discord, stringResource(R.string.discord_task_image)),
        Pair(R.drawable.ic_bober, stringResource(R.string.bober_task_image)),
        Pair(R.drawable.ic_xportal, stringResource(R.string.xportal_task_image))
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        for (rowIcons in taskList.chunked(2)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.sdp)
            ) {
                rowIcons.forEach { (painter, label) ->
                    CvImageView(
                        painter = painter, label, modifier = Modifier.scale(0.96f)
                    )
                }
            }
        }
    }
}

/*@Composable
fun CustomTabBar() {
    val tabs = listOf("Airdrop Tickets", "Contest Rules", "FAQ’s")
    var selectedTab by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(unselectedTextColor),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEachIndexed { index, title ->
            val interactionSource = remember { MutableInteractionSource() }
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(40.dp)
                    .padding(horizontal = 8.dp)
                    .background(
                        color = if (selectedTab == index) purpleBgColor else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable(
                        interactionSource = interactionSource, indication = null
                    ) {
                        selectedTab = index
                    }
                    .padding(horizontal = 16.dp)) {
                CvTextView(
                    txt = title,
                    textColor = if (selectedTab == index) purpleColor else subtitleTxtColor,
                    fontSize = 14.ssp,
                    textAlign = TextAlign.Center,
                    style = if (selectedTab == index) productSansMedium else productSansRegular
                )
            }
        }
    }
}*/

@Composable
fun CustomTabBar() {
    val tabs = listOf(
        stringResource(R.string.airdrop_tickets),
        stringResource(R.string.contest_rules),
        stringResource(R.string.faq_s)
    )
    var selectedTab by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(unselectedTextColor),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed { index, title ->
                val interactionSource = remember { MutableInteractionSource() }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(40.dp)
                        .padding(horizontal = 10.dp)
                        .background(
                            color = if (selectedTab == index) purpleBgColor else Color.Transparent,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable(
                            interactionSource = interactionSource, indication = null
                        ) {
                            selectedTab = index
                        }
                        .padding(horizontal = 16.dp) //Padding for rounded box
                ) {
                    CvTextView(
                        txt = title,
                        textColor = if (selectedTab == index) purpleColor else subtitleTxtColor,
                        fontSize = 16.ssp,
                        textAlign = TextAlign.Start,
                        style = if (selectedTab == index) productSansMedium else productSansRegular
                    )
                }
            }
        }

        Spacer(Modifier.height(26.sdp))

        when (selectedTab) {
            0 -> AirdropContent()
            1 -> ContestRulesPointWithBullet()
            2 -> ExpandableFaqList()
        }
    }
}

@Composable
fun ContestRulesPointWithBullet() {

    val contestRulesPoint = listOf(
        Pair(
            stringResource(R.string.create_an_ixfi_account),
            stringResource(R.string.create_an_ixfi_account_desc)
        ), Pair(
            stringResource(R.string.download_blockgames_app),
            stringResource(R.string.download_blockgames_app_desc)
        ), Pair(
            stringResource(R.string.earn_and_use_ixfi_points),
            stringResource(R.string.earn_and_use_ixfi_points_desc)
        ), Pair(
            stringResource(R.string.collect_a_bober_nft),
            stringResource(R.string.collect_a_bober_nft_desc)
        )
    )


//    Spacer(Modifier.height(34.sdp))

    Column(modifier = Modifier.padding(start = 24.sdp, end = 12.sdp, top = 4.sdp)) {
        contestRulesPoint.forEachIndexed { index, (title, description) ->

            TextWithBullet(title, index)

            CvTextView(
                txt = description,
                style = robotoRegular,
                textColor = subtitleTxtColor,
                fontSize = 14.ssp,
                letterSpacing = TextUnit(0.3f, TextUnitType.Sp),
                modifier = Modifier.padding(top = 14.sdp, start = 22.sdp, end = 10.sdp)
            )
        }
    }
}

@Composable
fun TextWithBullet(txt: String, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = if (index >= 1) 16.sdp else 0.sdp)
    ) {
        Canvas(
            modifier = Modifier.size(6.dp)
        ) {
            drawCircle(bulletPointColor)
        }

        CvTextView(
            txt = txt,
            style = robotoMedium,
            textColor = headerTxtColor,
            fontSize = 16.ssp,
            modifier = Modifier.padding(start = 16.sdp)
        )
    }

}

@Composable
fun ExpandableFaqList() {

    val faqPoints = listOf(
        Pair(
            stringResource(R.string.where_can_you_buy_bober),
            stringResource(R.string.where_can_you_buy_bober_desc)
        ),
        Pair(
            stringResource(R.string.what_is_the_daily_trading_volume_of_bober),
            stringResource(R.string.where_can_you_buy_bober_desc)
        ),
        Pair(
            stringResource(R.string.what_is_the_all_time_low_for_bober),
            stringResource(R.string.where_can_you_buy_bober_desc)
        ),
        Pair(
            stringResource(R.string.what_is_the_fully_diluted_valuation_of_bober),
            stringResource(R.string.where_can_you_buy_bober_desc)
        ),
    )

    var expandedIndex by remember { mutableIntStateOf(-1) }


    Column(modifier = Modifier.padding(start = 22.sdp, end = 16.sdp)) {
        faqPoints.forEachIndexed { index, faq ->
            ExpandableTextView(title = faq.first,
                description = faq.second,
                isExpanded = expandedIndex == index,
                onTitleClick = {
                    expandedIndex = if (expandedIndex == index) -1 else index
                })
        }

        HelpAndSupport()
    }
}

@Composable
fun ExpandableTextView(
    title: String, description: String, isExpanded: Boolean, onTitleClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    Row(verticalAlignment = Alignment.Top, modifier = Modifier.fillMaxWidth()) {
        CvImageView(
            painter = R.drawable.ic_trangle,
            contentDes = stringResource(R.string.bullet_point),
            modifier = Modifier
                .size(12.sdp)
                .padding(top = 2.sdp)
                .rotate(if (isExpanded) 360f else 270f)
        )
        Column(modifier = Modifier.padding(start = 12.sdp, bottom = 28.sdp)) {
            // Title
            CvTextView(
                txt = title,
                fontSize = 15.sp,
                textColor = headerTxtColor,
                modifier = Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null, // Disable the ripple effect
                        onClick = onTitleClick // Trigger click event for title
                    )
                    .padding(bottom = 2.dp, start = 4.sdp),
                style = robotoMedium,
                letterSpacing = TextUnit(0.3f, TextUnitType.Sp)
            )

            // Description
            AnimatedVisibility(visible = isExpanded) {
                Text(
                    text = description,
                    fontSize = 13.sp,
                    color = subtitleTxtColor,
                    style = robotoRegular,
                    modifier = Modifier.padding(top = 12.sdp, start = 4.sdp),
                    letterSpacing = TextUnit(0.3f, TextUnitType.Sp)
                )
            }
        }
    }
}

@Composable
fun HelpAndSupport() {

    Row(
        modifier = Modifier.border(
            1.sdp, color = borderColor, shape = RoundedCornerShape(14.sdp)
        ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CvImageView(
            painter = R.drawable.ic_help_and_support,
            contentDes = stringResource(R.string.help_and_support),
            modifier = Modifier
                .padding(start = 12.sdp, end = 16.sdp, bottom = 8.sdp)
                .weight(0.2f)
        )

        Column(
            modifier = Modifier
                .padding(vertical = 14.sdp)
                .weight(0.6f)
        ) {
            CvTextView(
                txt = stringResource(R.string.help_support),
                style = productSansMedium,
                fontSize = 16.ssp,
                textColor = headerTxtColor
            )

            CvTextView(
                txt = stringResource(R.string.our_support_team_is_ready_to_answer_your_questions_24_7),
                style = robotoRegular,
                fontSize = 14.ssp,
                textColor = subtitleTxtColor,
                modifier = Modifier.padding(top = 6.sdp)
            )
        }

        CvImageView(
            painter = R.drawable.ic_right_arrow,
            stringResource(R.string.baer),
            modifier = Modifier
                //.size(16.sdp)
                .weight(0.2f)
                .scale(1.1f)
                .padding(start = 18.sdp, bottom = 8.sdp)
        )
    }
}


@Composable
fun MoreAboutBober() {

    //Title text
    GradiantTitleText(stringResource(R.string.more_about_bober))

    Spacer(Modifier.height(28.sdp))

    CvImageView(
        painter = R.drawable.more_about_bober,
        contentDes = stringResource(R.string.more_about_bober_banner)
    )
}

@Composable
fun LegalDisclaimer() {
    Column(
        modifier = Modifier
            .padding(start = 20.sdp, end = 16.sdp)
            .navigationBarsPadding()
    ) {

        CvTextView(
            txt = "Legal Disclaimer",
            style = sfProDisplaySemiBold,
            fontSize = 17.ssp,
            textColor = headerTxtColor
        )

        CvTextView(
            txt = stringResource(R.string.legal_disclaimer),
            style = robotoRegular,
            fontSize = 13.ssp,
            textColor = subtitleTxtColor,
            modifier = Modifier.padding(vertical = 26.sdp)
        )
    }
}

@Composable
fun NotifyViewWithTimer() {
    val startTimeInMillis = (7L * 24 * 60 * 60 + 15L * 60 * 60 + 12L * 60 + 59L) * 1000
    var timeLeft by remember { mutableStateOf(startTimeInMillis) }

    LaunchedEffect(Unit) {
        object : CountDownTimer(startTimeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished
            }

            override fun onFinish() {
                timeLeft = 0
            }
        }.start()
    }

    val days = (timeLeft / (1000 * 60 * 60 * 24)).toInt()
    val hours = ((timeLeft / (1000 * 60 * 60)) % 24).toInt()
    val minutes = ((timeLeft / (1000 * 60)) % 60).toInt()
    val seconds = ((timeLeft / 1000) % 60).toInt()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.sdp)
            .background(Color(0xFFFFFBF2), RoundedCornerShape(8.sdp)),
        contentAlignment = Alignment.BottomStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 26.sdp, end = 26.sdp, bottom = 18.sdp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CvTextView(
                    txt = stringResource(R.string.available_in),
                    style = robotoRegular,
                    fontSize = 14.ssp,
                    textColor = headerTxtColor
                )

                CvTextView(txt = "${days}D : ${hours}H : ${minutes}M : ${seconds}S",
                    style = productSansBold,
                    fontSize = 15.ssp,
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
                        })
            }

            // Notify Button
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CvTextView(
                    txt = "\uD83D\uDC49 ", fontSize = 18.sp, textAlign = TextAlign.Center
                )
                CvTextView(
                    txt = stringResource(R.string.notify_me),
                    style = productSansBold,
                    textColor = purperTextColor,
                    fontSize = 16.ssp
                )
                CvImageView(
                    painter = R.drawable.ic_back,
                    contentDes = stringResource(R.string.notify_arrow),
                    modifier = Modifier
                        .rotate(180f)
                        .padding(start = 8.sdp, end = 8.sdp, bottom = 3.sdp)
                        .size(16.sdp),
                    colorFilter = ColorFilter.tint(purperTextColor)
                )
            }
        }
    }
}

@Composable
fun AirdropContent() {
//    Spacer(Modifier.height(20.sdp))
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 6.sdp, end = 6.sdp, top = 3.sdp)
            .paint(painter = painterResource(R.drawable.bg_texture))

    ) {
        Column(modifier = Modifier.padding(horizontal = 16.sdp)) {
            CvTextView(
                txt = stringResource(R.string.beavers_not_only_build_dams_but_also_secure_more_airdrop_tickets),
                textColor = headerTxtColor,
                style = productSansMedium,
                fontSize = 20.ssp,
                letterSpacing = TextUnit(0.1f, TextUnitType.Sp),
                modifier = Modifier.padding(
                    start = 18.sdp, end = 100.sdp, top = 20.sdp
                )
            )

            Spacer(Modifier.height(20.sdp))

            HorizontalDotedLine()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.sdp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                //Avalible in
                Column(modifier = Modifier.weight(0.8f)) {
                    CvTextView(
                        txt = stringResource(R.string.available_in),
                        textColor = headerTxtColor,
                        style = productSansRegular,
                        fontSize = 11.ssp
                    )

                    Spacer(Modifier.height(6.sdp))

                    CvTextView(
                        txt = stringResource(R.string._7d_11h),
                        textColor = headerTxtColor,
                        style = productSansBold,
                        fontSize = 19.ssp,
                        letterSpacing = TextUnit(0.4f, TextUnitType.Sp),
                    )
                }

                CvImageView(
                    painter = R.drawable.vertical_doted_line,
                    contentDes = stringResource(R.string.vertical_doted_line),
                    modifier = Modifier
                        .weight(0.1f)
                        .size(56.sdp)
                )

                //Get using
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.9f)
                        .padding(start = 4.sdp)
                ) {
                    CvTextView(
                        txt = stringResource(R.string.get_using),
                        textColor = headerTxtColor,
                        style = productSansRegular,
                        fontSize = 11.ssp
                    )

                    CvTextView(
                        txt = stringResource(R.string._20),
                        textColor = headerTxtColor,
                        style = productSansBold,
                        fontSize = 18.ssp,
                        modifier = Modifier.padding(start = 14.sdp, end = 10.sdp)
                    )

                    CvImageView(
                        painter = R.drawable.ic_point,
                        contentDes = stringResource(R.string.point_icon),
                    )
                }
            }

            HorizontalDotedLine()

            CvImageView(
                painter = R.drawable.airdrop_bear,
                contentDes = stringResource(R.string.more_about_bober_banner)
            )

            HorizontalDotedLine()

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 22.sdp, end = 18.sdp, start = 18.sdp)
            ) {
                CvTextView(
                    txt = "\uD83D\uDC49 ", fontSize = 18.sp, textAlign = TextAlign.Center
                )
                CvTextView(
                    txt = stringResource(R.string.notify_me),
                    style = sfProDisplayBold,
                    textColor = txtPinkColor,
                    fontSize = 18.ssp,
                    letterSpacing = TextUnit(0.4f, TextUnitType.Sp),
                    modifier = Modifier.padding(end = 12.sdp)
                )
                CvImageView(
                    painter = R.drawable.ic_notify_icon,
                    contentDes = stringResource(R.string.more_about_bober_banner),
                    modifier = Modifier
                        .padding(top = 5.sdp)
                        .size(12.sdp)
                )

            }

            CvImageView(
                painter = R.drawable.ic_curved_line,
                contentDes = stringResource(R.string.curved_line),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun HorizontalDotedLine() {
    Box(
        Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(lineColor, shape = DottedShape(step = 10.dp))
    )
}

private data class DottedShape(
    val step: Dp
) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ) = Outline.Generic(Path().apply {
        val stepPx = with(density) { step.toPx() }
        val stepsCount = (size.width / stepPx).roundToInt()
        val actualStep = size.width / stepsCount
        val dotSize = Size(width = actualStep / 2, height = size.height)
        for (i in 0 until stepsCount) {
            addRect(
                Rect(
                    offset = Offset(x = i * actualStep, y = 0f), size = dotSize
                )
            )
        }
        close()
    })
}

