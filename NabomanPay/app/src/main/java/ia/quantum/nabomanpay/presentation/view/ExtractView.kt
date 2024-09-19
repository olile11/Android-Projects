package ia.quantum.nabomanpay.presentation.view

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ia.quantum.nabomanpay.R
import ia.quantum.quantumpay.model.Extract

class ExtractView {

    @Composable
    fun ExtractItem(extract: Extract, modifier: Modifier){
        val lineHeight = 5
        Card (
            modifier = modifier,
            border = BorderStroke(1.dp, color = Color(0xFF000000))
        ){
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                    Text(text = "Enviado", fontWeight = FontWeight.Bold)
                    Text(text = "R$ ${extract.balance}", fontWeight = FontWeight.Bold)
                }
                //Spacer(modifier = Modifier.weight(1f))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Name", fontWeight = FontWeight.Medium)
                    Text(text = extract.name, fontWeight = FontWeight.Medium)
                }
                //Spacer(modifier = Modifier.weight(1f))
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "Instituição", fontWeight = FontWeight.Medium)
                    Text(text = extract.institution, fontWeight = FontWeight.Medium)
                }
            }
        }
    }

    @Composable
    fun CardBalance(){
        Card (
            modifier = Modifier
                .padding(16.dp)
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar(modifier: Modifier = Modifier){
        CenterAlignedTopAppBar(
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
    fun ExtractList(extractList: List<Extract>){
        Scaffold(
            topBar = {TopBar()}
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CardBalance()
                LazyColumn(contentPadding = it) {
                    items(extractList) { extract ->
                        ExtractItem(
                            extract = extract,
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}