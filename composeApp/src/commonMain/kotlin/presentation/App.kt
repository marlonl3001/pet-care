package presentation

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.rememberNavigator
import navigation.SetupNavGraph
import ui.theme.PetCareTheme

@Composable
fun App() {
    PetCareTheme {
        PreComposeApp {
            val navigator = rememberNavigator()
            SetupNavGraph(navigator)
        }
    }
}