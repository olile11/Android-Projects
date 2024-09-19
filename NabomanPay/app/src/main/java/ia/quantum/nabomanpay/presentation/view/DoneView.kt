package ia.quantum.nabomanpay.presentation.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ia.quantum.nabomanpay.R
import ia.quantum.nabomanpay.theme.Montserrat
import ia.quantum.nabomanpay.data.ClientDB
import ia.quantum.quantumpay.model.Client

class DoneView {

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
    fun CardBalance(modifier: Modifier=Modifier){
        Card (
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxWidth()
                .height(100.dp),
            border = BorderStroke(1.dp, color = Color(0xFF000000))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Saldo disponível", fontWeight = FontWeight.Bold)
                Text(text = "R$ 2000.00")
            }
        }
    }

    @Composable
    fun DoneCard(modifier: Modifier=Modifier){
        Scaffold(
            topBar = { TopBar() }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = modifier
                        .size(128.dp),
                    painter = painterResource(id = R.drawable.icons8_done_256),
                    contentScale = ContentScale.Crop,
                    contentDescription = null)
            }
        }
    }
}