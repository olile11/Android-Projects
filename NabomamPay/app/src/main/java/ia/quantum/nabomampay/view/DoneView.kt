package ia.quantum.nabomampay.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class DoneView: ComposeScreen {
    @Composable
    override fun Content(navController: NavController, modifier: Modifier) {
        Scaffold(
            topBar = { BarView().TopBar() },
            bottomBar = {BarView().BottomBar(navController = navController)}
        ) { innerPadding ->
            LaunchedEffect(Unit) {
                kotlinx.coroutines.delay(2000)
                navController.navigate("home")
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "Payment Done",
                        tint = Color.Green,
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
    }

}