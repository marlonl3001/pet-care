package navigation

sealed class Screen(val route: String) {
    data object Splash: Screen("splash")
    data object Onboarding: Screen("onboarding")
    data object Home: Screen("home")
    data object Login: Screen("login")
    data object PetDetail: Screen("pet_detail")
    data object PetDetailMenu: Screen("pet_detail_menu")

}
