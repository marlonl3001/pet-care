package navigation

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import presentation.screens.home.HomeScreen
import presentation.screens.login.LoginScreen
import presentation.screens.onboarding.OnboardingScreen
import presentation.screens.pet_detail.PetDetailScreen
import presentation.screens.splash.SplashScreen

@Composable
fun SetupNavGraph(navigator: Navigator) {
    NavHost(
        navigator = navigator,
        initialRoute = Screen.Splash.route) {
        scene(route = Screen.Splash.route) {
            SplashScreen(navigator = navigator)
        }
        scene(route = Screen.Onboarding.route) {
            OnboardingScreen(navigator = navigator)
        }
        scene(route = Screen.Login.route) {
            LoginScreen(navigator = navigator)
        }
        scene(route = Screen.Home.route) {
            HomeScreen(navigator = navigator)
        }
        scene(route = Screen.PetDetail.route) {
            PetDetailScreen(navigator = navigator)
        }
        scene(route = Screen.PetDetailMenu.route) {
            PetDetailScreen(navigator = navigator)
        }
    }
}