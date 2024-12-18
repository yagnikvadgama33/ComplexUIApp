package com.example.complexuiapp.helper

import androidx.compose.ui.graphics.Color

data class CalenderView(
    var day: Int,
    var monthAndYear: String,
    var remark: String,
    var bgColor: Color,
    var isSingleDigit:Boolean //to to zero if single digit fount
)
