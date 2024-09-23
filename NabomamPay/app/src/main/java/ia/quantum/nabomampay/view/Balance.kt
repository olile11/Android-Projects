package ia.quantum.nabomampay.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import ia.quantum.nabomampay.R

class Balance {
    @Composable
    fun CardBalance(modifier: Modifier = Modifier){
        Card (
            modifier = modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(dimensionResource(R.dimen.padding_medium)),
            border = BorderStroke(1.dp, color = Color(0xFF000000)),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_medium)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Saldo disponível",
                    style = MaterialTheme.typography.displayMedium)
                Text(text = "R$ 2000.00",
                    style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}