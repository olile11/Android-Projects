package ia.quantum.nabomanpay.presentation.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ia.quantum.nabomanpay.R
import ia.quantum.nabomanpay.theme.Montserrat
import ia.quantum.nabomanpay.data.ClientDB
import ia.quantum.quantumpay.model.Client

class HomeView (private val navController: NavController): ComposeScreen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar(modifier: Modifier = Modifier){
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            ),
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.image_size))
                            .padding(dimensionResource(id = R.dimen.padding_small)),
                        painter = painterResource(id = R.drawable.icons8_us_dollar_50_1),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(id = R.string.app_name),
                        //style = MaterialTheme.typography.displayLarge
                    )
                }
            },
            modifier = modifier
        )
    }

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
                fontFamily = Montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(1.dp)
            )
            Text(
                text = "Conta ...",
            )
        }
    }

    @Composable
    fun Profile(client: Client,
                modifier: Modifier = Modifier){
        Card(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary),
            border = BorderStroke(1.dp, color = Color(0xFF000000))
        ){
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ClientPicture(client.imageResourceId)
                ClientInformation(client.clientName, client.clientAge)
            }
        }
    }

    @Composable
    fun AccountDescription(modifier: Modifier = Modifier){
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
                    Text(text = "Agência: 0001",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                    Text(text = "Conta: 23.4593 - 45",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                    Text(text = "Saldo: R$3000,00",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                }
                Button(onClick = { }, shape = RoundedCornerShape(20)) {
                    Text(text = "Extrato",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(vertical = 8.dp),
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
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                    Divider(
                        modifier = Modifier.padding(4.dp),
                        thickness = 2.dp)
                    Text(text = "Mean R$5000 - 35.71%",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                    Divider(
                        modifier = Modifier.padding(4.dp),
                        thickness = 2.dp)
                    Text(text = "Min R$1000 - 7.14%",
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp)
                }
                Button(onClick = { /*TODO*/ }) {}
            }
        }
    }

    @Composable
    fun PaymentType(modifier: Modifier= Modifier){
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
                            .padding(dimensionResource(R.dimen.padding_small)),
                        horizontalArrangement = Arrangement.Center,
                    ){
                        Image(
                            modifier = modifier
                                .size(dimensionResource(R.dimen.image_size))
                                .padding(dimensionResource(R.dimen.padding_small))
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(R.drawable.icons8_water_94),
                            contentDescription = null
                        )
                        Image(
                            modifier = modifier
                                .size(dimensionResource(R.dimen.image_size))
                                .padding(dimensionResource(R.dimen.padding_small))
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(R.drawable.icons8_wifi_94),
                            contentDescription = null
                        )
                        Image(
                            modifier = modifier
                                .size(dimensionResource(R.dimen.image_size))
                                .padding(dimensionResource(R.dimen.padding_small))
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(R.drawable.icons8_energy_94),
                            contentDescription = null
                        )
                    }
                    Button(onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(20),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )) {
                        Text(text = "Pagar boleto",
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

        }
    }

    @Composable
    override fun Content() {
        Scaffold(
            topBar = { TopBar() }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Profile(
                    client = ClientDB().loadData()[0],
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                )
                AccountDescription()
                StatDescription()
                PaymentType()
            }
        }
    }
}