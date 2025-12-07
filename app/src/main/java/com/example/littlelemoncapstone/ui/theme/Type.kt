package com.example.littlelemoncapstone.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemoncapstone.R

val MarkaziFamily = FontFamily(
    Font(R.font.markazi_regular, FontWeight.Normal)
)

val KarlaFamily = FontFamily(
    Font(R.font.karla_regular, FontWeight.Normal)
)

val LittleLemonTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = MarkaziFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 54.sp,
        lineHeight = 60.sp
    ),
    titleLarge = TextStyle(
        fontFamily = MarkaziFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 44.sp
    ),
    titleMedium = TextStyle(
        fontFamily = MarkaziFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 36.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = KarlaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = KarlaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.sp
    ),
    labelLarge = TextStyle(
        fontFamily = KarlaFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp
    )
)