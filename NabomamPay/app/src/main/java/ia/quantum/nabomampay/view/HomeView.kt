package ia.quantum.nabomampay.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ia.quantum.nabomampay.R
import ia.quantum.nabomampay.data.ClientDB
import ia.quantum.nabomampay.domain.Client

class HomeView: ComposeScreen {
    @Composable
    fun ClientPicture(
        @DrawableRes clientIcon: Int,
        modifier: Modifier = Modifier
    ) {
        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            painter = painterResource(clientIcon),

            contentDescription = null
        )
    }
    @Composable
    fun ClientInformation(
        clientName: String,
        clientAge: Int,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            Text(
                text = clientName,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(1.dp)
            )
            Text(
                text = "Conta ...",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    @Composable
    fun Profile(navController: NavController, client: Client,
                modifier: Modifier = Modifier){
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.padding_small)),
            border = BorderStroke(1.dp, color = Color(0xFF000000)),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary)
        ){
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
                    .clickable { navController.navigate("profile") },
                verticalAlignment = Alignment.CenterVertically
            ) {
                ClientPicture(client.imageResourceId)
                ClientInformation(client.clientName, client.clientAge)
            }
        }
    }

    @Composable
    fun AccountDescription(navController: NavController, modifier: Modifier = Modifier){
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary),
            border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Agência: 0001",
                        style = MaterialTheme.typography.labelSmall)
                    Text(text = "Conta: 23.4593 - 45",
                        style = MaterialTheme.typography.labelSmall)
                    Text(text = "Saldo: R$3000,00",
                        style = MaterialTheme.typography.labelSmall)
                }
                Button(
                    onClick = { navController.navigate("statement") },
                    shape = RoundedCornerShape(15)) {
                    Text(
                        text = "Extrato",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier
                            .padding(vertical = dimensionResource(id = R.dimen.padding_small)),
                    )
                }
            }

        }
    }

    @Composable
    fun StatDescription(modifier: Modifier= Modifier){
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary),
            border = BorderStroke(1.dp, color = Color(0xFF000000))
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Max R$8000 - 57.14%",
                        style = MaterialTheme.typography.labelSmall)
                    Divider(
                        modifier = Modifier.padding(4.dp), thickness = 2.dp)
                    Text(text = "Mean R$5000 - 35.71%",
                        style = MaterialTheme.typography.labelSmall)
                    Divider(
                        modifier = Modifier.padding(4.dp), thickness = 2.dp)
                    Text(text = "Min R$1000 - 7.14%",
                        style = MaterialTheme.typography.labelSmall)
                }
                Button(onClick = { /*TODO*/ }) {}
            }
        }
    }

    @Composable
    fun PaymentType(navController: NavController, modifier: Modifier = Modifier){
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium)),
            colors = CardDefaults
                .cardColors(
                    containerColor = Color(0xFFFFFFFF)),
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(dimensionResource(R.dimen.padding_medium)),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        FloatingActionButton(
                            onClick = {
                                navController.navigate("pay/${R.drawable.icons8_water_94}") },
                            shape = CircleShape,
                            containerColor = Color.White,
                            modifier = modifier
                                .background(brush = Brush.radialGradient(listOf(Color.Blue, Color.White)),
                                shape = CircleShape),
                            ) {
                            Image(
                                modifier = modifier
                                    .size(dimensionResource(R.dimen.image_size))
                                    .padding(dimensionResource(R.dimen.padding_small))
                                    .clip(CircleShape),
                                painter = painterResource(R.drawable.icons8_water_94),
                                contentDescription = null)
                        }
                        FloatingActionButton(
                            onClick = {
                                navController.navigate("pay/${R.drawable.icons8_wifi_94}") },
                            shape = CircleShape,
                            containerColor = Color.White) {
                            Image(
                                modifier = modifier
                                    .size(dimensionResource(R.dimen.image_size))
                                    .padding(dimensionResource(R.dimen.padding_small))
                                    .clip(CircleShape),
                                painter = painterResource(R.drawable.icons8_wifi_94),
                                contentDescription = null)
                        }
                        FloatingActionButton(
                            onClick = {
                                navController.navigate("pay/${R.drawable.icons8_energy_94}") },
                            shape = CircleShape,
                            containerColor = Color.White) {
                            Image(
                                modifier = modifier
                                    .size(dimensionResource(R.dimen.image_size))
                                    .padding(dimensionResource(R.dimen.padding_small))
                                    .clip(CircleShape),
                                painter = painterResource(R.drawable.icons8_energy_94),
                                contentDescription = null)
                        }
                    }
                    Button(
                        onClick = {
                            navController.navigate("pay/${R.drawable.icons8_services_138}") },
                        shape = RoundedCornerShape(20),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )) {
                        Text(text = "Pagar boleto",
                            style = MaterialTheme.typography.labelSmall,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = dimensionResource(id = R.dimen.padding_small))
                        )
                    }
                }
            }

        }
    }

    @Composable
    override fun Content(navController: NavController, modifier: Modifier) {
        Scaffold(
            topBar = { BarView().TopBar() },
            bottomBar = {BarView().BottomBar(navController = navController)}
        ) { innerPadding ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Profile(
                    navController,
                    client = ClientDB().loadData()[2],
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                )
                AccountDescription(navController)
                StatDescription()
                PaymentType(navController)
            }
        }

    }
}