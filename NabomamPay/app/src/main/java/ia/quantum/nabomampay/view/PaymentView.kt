package ia.quantum.nabomampay.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import ia.quantum.nabomampay.R

class PaymentView {
    @Composable
    fun Content(navController: NavController, imgUri: Int, modifier: Modifier) {
        Scaffold(
            topBar = { BarView().TopBar() },
            bottomBar = {BarView().BottomBar(navController = navController)}
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Balance().CardBalance()
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.user_size))
                        .clip(CircleShape),
                    painter = painterResource(imgUri),
                    contentDescription = null)
                ButtonsView().PayInputCard(navController)
                ButtonsView().ButtonGroup(navController = navController)
            }
        }
    }
}