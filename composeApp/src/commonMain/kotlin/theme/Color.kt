package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val light_primary = Color(0xFF4756C8)
val light_onPrimary = Color(0xFFFFFFFF)
val light_primaryContainer = Color(0xFFFF9F6A)
val light_onPrimaryContainer = Color(0xFF000B62)
val light_secondary = Color(0xFFFF9F6A)
val light_onSecondary = Color(0xFFFFFFFF)
val light_secondaryContainer = Color(0xFFFFDBCA)
val light_onSecondaryContainer = Color(0xFF331100)
val light_tertiary = Color(0xFF1F33D1)
val light_onTertiary = Color(0xFFFFFFFF)
val light_tertiaryContainer = Color(0xFFDFE0FF)
val light_onTertiaryContainer = Color(0xFF000964)
val light_error = Color(0xFFBA1A1A)
val light_errorContainer = Color(0xFFFFDAD6)
val light_onError = Color(0xFFFFFFFF)
val light_onErrorContainer = Color(0xFF410002)
val light_background = Color(0xFFFAFDFD)
val light_onBackground = Color(0xFF191C1D)
val light_outline = Color(0xFF6F797A)
val light_inverseOnSurface = Color(0xFFFFFFFF)//Color(0xFFEFF1F1)
val light_inverseSurface = Color(0xFFFFFFFF)
val light_inversePrimary = Color(0xFFBCC2FF)
val light_surfaceTint = Color(0xFFFFFFFF)
val light_outlineVariant = Color(0xFFBFC8CA)
val light_scrim = Color(0xFF000000)
val light_surface = Color(0xFFFFFFFF)
val light_onSurface = Color(0xFF191C1D)
val light_surfaceVariant = Color(0xFFFFFFFF)
val light_onSurfaceVariant = Color(0xFF3F484A)

val dark_primary = Color(0xFFBCC2FF)
val dark_onPrimary = Color(0xFF051A96)
val dark_primaryContainer = Color(0xFF2838AB)
val dark_onPrimaryContainer = Color(0xFFDFE0FF)
val dark_secondary = Color(0xFFFFB690)
val dark_onSecondary = Color(0xFF542100)
val dark_secondaryContainer = Color(0xFF783200)
val dark_onSecondaryContainer = Color(0xFFFFDBCA)
val dark_tertiary = Color(0xFFBDC2FF)
val dark_onTertiary = Color(0xFF00159E)
val dark_tertiaryContainer = Color(0xFF152BCC)
val dark_onTertiaryContainer = Color(0xFFDFE0FF)
val dark_error = Color(0xFFFFB4AB)
val dark_errorContainer = Color(0xFF93000A)
val dark_onError = Color(0xFF690005)
val dark_onErrorContainer = Color(0xFFFFDAD6)
val dark_background = Color(0xFF191C1D)
val dark_onBackground = Color(0xFFE1E3E3)
val dark_outline = Color(0xFF899294)
val dark_inverseOnSurface = Color(0xFF191C1D)
val dark_inverseSurface = Color(0xFFE1E3E3)
val dark_inversePrimary = Color(0xFF4352C4)
val dark_surfaceTint = Color(0xFFBCC2FF)
val dark_outlineVariant = Color(0xFF3F484A)
val dark_scrim = Color(0xFF000000)
val dark_surface = Color(0xFF101415)
val dark_onSurface = Color(0xFFC4C7C7)
val dark_surfaceVariant = Color(0xFF3F484A)
val dark_onSurfaceVariant = Color(0xFFBFC8CA)

val HealthColor = Color(0xFF8980FF)
val HygieneColor = Color(0xFFFF9F6A)
val AppointmentColor = Color(0xFFFFB5B1)
val NutritionColor = Color(0xFFEABA51)
val GrayBlue = Color(0xFFE3E7FF)

val LightGray = Color(0xFF6F6F6F)
val DarkGray = Color(0xFF292929)

val SelectedIndicator = Color(0XFFFFC94D)
val UnselectedIndicator = Color(0xFFE6E8F8)
val Blue700 = Color(0xFF4756C8)

val ColorScheme.statusBarColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Blue700

val ColorScheme.welcomeScreenBackgroundColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Color.White

val ColorScheme.titleColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else DarkGray

val ColorScheme.descriptionColor
    @Composable
    get() = LightGray

val ColorScheme.activeIndicatorColor
    @Composable
    get() = SelectedIndicator

val ColorScheme.inactiveIndicatorColor
    @Composable
    get() = UnselectedIndicator

val ColorScheme.buttonBackgroundColor
    @Composable
    get() = Blue700

val ColorScheme.topAppBarContentColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) LightGray else Color.White

val ColorScheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else light_secondary

val ColorScheme.healthColor: Color
    @Composable
    get() = HealthColor

val ColorScheme.hygieneColor: Color
    @Composable
    get() = HygieneColor

val ColorScheme.appointmentColor: Color
    @Composable
    get() = AppointmentColor

val ColorScheme.nutritionColor: Color
    @Composable
    get() = NutritionColor

val ColorScheme.addPetButtonColor: Color
    @Composable
    get() = HygieneColor

val ColorScheme.grayBlueColor: Color
    @Composable
    get() = GrayBlue