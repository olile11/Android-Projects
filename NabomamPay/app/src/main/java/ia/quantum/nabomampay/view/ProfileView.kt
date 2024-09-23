package ia.quantum.nabomampay.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ia.quantum.nabomampay.R
import ia.quantum.nabomampay.ui.theme.Montserrat

class ProfileView: ComposeScreen {
    @Composable
    fun UserInformation(navController: NavController,
                        modifier: Modifier = Modifier){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Dados Pessoais",
                    fontFamily = Montserrat,
                    style = MaterialTheme.typography.displayMedium)
                IconButton(onClick = { navController.navigate("edit_profile") }) {
                    Icon(imageVector = Icons.Outlined.Edit, contentDescription = null)
                }
            }
            HorizontalDivider(thickness = 4.dp,
                color = Color(0xFF000000))
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(text = "Da vince",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_small)),
                    )
                Text(text = "713.854.768-12",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_small)))
                Text(text = "25/12/2000",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_small)))
                Text(text = "50355-45, Tabuleiro",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_small)))
            }
        }
    }

    @Composable
    fun ParentInformation(navController: NavController,
                          modifier: Modifier = Modifier){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Filhação",
                    style = MaterialTheme.typography.displayMedium)
                IconButton(onClick = { navController.navigate("edit_profile") }) {
                    Icon(imageVector = Icons.Outlined.Edit, contentDescription = null)
                }
            }
            HorizontalDivider(thickness = 4.dp,
                color = Color(0xFF000000))
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(text = "Namirana Bebe",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_small)))
                Text(text = "Gau Bishop",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_small)))
            }
        }
    }

    @Composable
    override fun Content(navController: NavController, padding: Modifier) {
        Scaffold(
            topBar = {BarView().TopBar()},
            bottomBar = {BarView().BottomBar(navController = navController)}
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(
                        vertical = dimensionResource(id = R.dimen.padding_medium),
                        horizontal = dimensionResource(id = R.dimen.padding_small)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                UserProfile().UserCard()
                Card(
                    shape = RoundedCornerShape(4),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color(0xFFFFFFFF)),
                    border = BorderStroke(1.dp, color = Color(0xFF000000))
                ) {
                    UserInformation(navController, Modifier)
                    ParentInformation(navController, Modifier)
                }
            }
        }
    }
}