package com.example.complexuiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.complexuiapp.helper.sdp
import com.example.complexuiapp.ui.theme.headerTxtColor
import com.example.complexuiapp.ui.theme.sfProDisplayRegular

@Composable
fun CvIconButton(
    iconPath: Int,
    iconDescription: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    androidx.compose.material3.IconButton(modifier = modifier,
        content = {
            Image(painterResource(iconPath), contentDescription = iconDescription)
        },
        onClick = {
            onClick.invoke()
        })
}

@Composable
fun CircularImageWithBackground(
    imageSrc: Int,
    contextScale: ContentScale = ContentScale.Crop,
    contentDescription: String,
    bgSize: Dp = 36.sdp,
    imgSize: Dp = 22.sdp,
    bgColor: Color = Color.White,
    modifier: Modifier,
    contentPaddingValue: PaddingValues = PaddingValues(6.sdp)
) {

    Box(
        modifier = modifier
            .size(bgSize)
            .clip(CircleShape)
            .background(bgColor)
    ) {
        Image(
            painter = painterResource(id = imageSrc),
            contentDescription = contentDescription,
            contentScale = contextScale,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(contentPaddingValue)
                .size(imgSize)
                .clip(CircleShape)
        )
    }
}

@Composable
fun CvImageView(
    painter: Int,
    contentDes: String,
    contextScale: ContentScale = ContentScale.Fit,
    modifier: Modifier = Modifier.padding(0.sdp),
    colorFilter: ColorFilter? = null
) {
    Image(
        painter = painterResource(painter),
        contentDes,
        modifier = modifier,
        contentScale = contextScale,
        colorFilter = colorFilter
    )
}

@Composable
fun CvTextView(
    txt: String = "hello",
    modifier: Modifier = Modifier.padding(0.sdp),
    style: TextStyle = sfProDisplayRegular,
    fontSize: TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    textColor: Color = headerTxtColor,
    minLines: Int = 1,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Visible,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    onTextLayout: (TextLayoutResult) -> Unit = {}
) {

    Text(
        text = txt,
        modifier = modifier,
        style = style,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = textColor,
        overflow = overflow,
        minLines = minLines,
        maxLines = maxLines,
        textAlign = textAlign,
        letterSpacing = letterSpacing,
        onTextLayout = onTextLayout
    )
}


