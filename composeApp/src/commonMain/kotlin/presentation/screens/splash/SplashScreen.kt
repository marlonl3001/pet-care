package presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.delay
import moe.tlaster.precompose.navigation.Navigator
import navigation.Screen

@Composable
fun SplashScreen(navigator: Navigator) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(MR.images.img_background_shade),
                contentScale = ContentScale.Crop),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(MR.images.img_logo),
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(MR.strings.welcome_message)
        )
        LaunchedEffect(true) {
            delay(1000)
            navigator.navigate(Screen.Onboarding.route)
        }
    }
}