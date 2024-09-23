package ia.quantum.nabomampay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ia.quantum.nabomampay.ui.theme.NabomamPayTheme
import ia.quantum.nabomampay.view.DoneView
import ia.quantum.nabomampay.view.HomeView
import ia.quantum.nabomampay.view.LoginView
import ia.quantum.nabomampay.view.PaymentView
import ia.quantum.nabomampay.view.ProfileEditView
import ia.quantum.nabomampay.view.ProfileView
import ia.quantum.nabomampay.view.StatementView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NabomamPayTheme {
                Scaffold(
                   // topBar = { TopBar() }
                ) { innerPadding ->
                    AppMain(
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AppMain(modifier: Modifier = Modifier) {

    Scaffold(

    ) { innerPadding ->
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                LoginView().Content(navController, Modifier.padding(innerPadding))
            }
            composable("home") {
                HomeView().Content(navController, Modifier.padding(innerPadding))
            }
            composable("statement") {
                StatementView().Content(navController,Modifier.padding(innerPadding))
            }
            composable("profile") {
                ProfileView().Content(navController,Modifier.padding(innerPadding))
            }
            composable("edit_profile") {
                ProfileEditView().Content(navController,Modifier.padding(innerPadding))
            }
            composable("pay/{img}") { backStackEntry ->
                val imgUri = backStackEntry.arguments?.getString("img")?.toInt()
                if (imgUri != null) {
                    PaymentView().Content(navController, imgUri, Modifier.padding(innerPadding))
                }
            }
            composable("done") {
                DoneView().Content(navController, Modifier.padding(innerPadding))
            }
        }
    }
}