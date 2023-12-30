package ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

val Font28 = 28.sp
val Font26 = 26.sp
val Font24 = 24.sp
val Font22 = 22.sp
val Font18 = 18.sp
val Font17 = 17.sp
val Font16 = 16.sp
val Font11 = 11.sp

val Typography.font28: TextUnit
    @Composable
    get() = Font28

val Typography.font26: TextUnit
    @Composable
    get() = Font26

val Typography.font24: TextUnit
    @Composable
    get() = Font24

val Typography.font22: TextUnit
    @Composable
    get() = Font22

val Typography.font18: TextUnit
    @Composable
    get() = Font18

val Typography.font17: TextUnit
    @Composable
    get() = Font17

val Typography.font16: TextUnit
    @Composable
    get() = Font16

val Typography.font11: TextUnit
    @Composable
    get() = Font11

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = Font16,
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