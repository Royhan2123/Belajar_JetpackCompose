import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.buildmoviewithcompose.activity.Detail.DetailScreen
import com.example.buildmoviewithcompose.activity.Home.HomeScreen
import com.example.buildmoviewithcompose.navigation.MoviesScreens

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MoviesScreens.HomeScreen.name
    ) {
        composable(MoviesScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(MoviesScreens.DetailScreen.name +"/{movie}",
            arguments = listOf(navArgument("movie"){ type = NavType.StringType})
        ){backStackEntry ->
            backStackEntry.arguments?.getString("movie")
        }
    }
}