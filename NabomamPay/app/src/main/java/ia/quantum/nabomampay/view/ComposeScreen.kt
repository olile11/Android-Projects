package ia.quantum.nabomampay.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

interface ComposeScreen {
    @Composable
    fun Content(navController: NavController, modifier: Modifier)
}