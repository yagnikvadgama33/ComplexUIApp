package com.example.complexuiapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.complexuiapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)


//Font Styles
var sfProDisplayRegular = TextStyle(
    fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
    fontSize = 12.sp,
)

var sfProDisplayBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.sf_pro_display_bold)),
    fontSize = 16.sp,
)

var sfProDisplaySemiBold =
    TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_semi_bold)),
        fontSize = 14.sp)

var robotoRegular = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontSize = 14.sp,
)

var robotoMedium = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_medium)),
    fontSize = 14.sp,
)

var robotoBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_bold)),
    fontSize = 12.sp,
)

var productSansRegular = TextStyle(
    fontSize = 13.sp,
    fontFamily = FontFamily(Font(R.font.new_product_sans_regular))
)

var productSansMedium = TextStyle(
    fontFamily = FontFamily(Font(R.font.product_sans_medium)),
    fontSize = 14.sp
)

var productSansBold = TextStyle(
    fontFamily = FontFamily(Font(R.font.product_sans_bold)),
    fontSize = 14.sp
)