package ia.quantum.nabomanpay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ia.quantum.nabomanpay.presentation.view.HomeView
import ia.quantum.nabomanpay.presentation.view.LoginView
import ia.quantum.nabomanpay.theme.NabomanPayTheme
import ia.quantum.nabomanpay.presentation.view.ProfileView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //NabomanPayTheme {
                AppMain()
            //}
        }
    }
}

@Composable
fun AppMain() {
//    val layoutDirection = LocalLayoutDirection.current
//    Surface(
//        modifier = Modifier
//            .fillMaxSize()
//            .statusBarsPadding()
//            .padding(
//                start = WindowInsets.safeDrawing
//                    .asPaddingValues()
//                    .calculateStartPadding(layoutDirection),
//                end = WindowInsets.safeDrawing
//                    .asPaddingValues()
//                    .calculateEndPadding(layoutDirection)
//            )
//    ) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginView(navController).Content() }
        composable("home") { HomeView(navController).Content() }
        composable("profile") { ProfileView(navController).Content() }
    }
}
