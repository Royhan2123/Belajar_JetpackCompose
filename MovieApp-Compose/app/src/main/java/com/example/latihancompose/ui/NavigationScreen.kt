import androidx.compose.runtime.Composable

enum class NavigationScreen {
    SplashScreen,
    HomePage,
    DetailPage;

    fun fromRoute(route: String?): NavigationScreen =
        when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            HomePage.name -> HomePage
            DetailPage.name -> DetailPage
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not a recognized")
        }
}
