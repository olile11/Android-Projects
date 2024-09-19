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

class SlipView {

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
    fun Eraser(name: String, onClear: () -> Unit) {
        if (name.isNotEmpty()) {
            IconButton(onClick = { onClear() }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Apagar texto",
                    tint = Color.Red
                )
            }
        }
    }

    @Composable
    fun ButtonView(text: String, modifier: Modifier=Modifier){
        Button(onClick = { }, shape = RoundedCornerShape(20),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF000000)
            )) {
            Text(
                text = text,
                color = Color.White,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = dimensionResource(R.dimen.padding_small))
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ReadTexInput(name: String, type: String){
        var inputName by remember { mutableStateOf("") }
        OutlinedTextField(
            value = inputName,
            onValueChange = { inputName = it },
            modifier = Modifier
                .fillMaxWidth(),
            trailingIcon = {
                Eraser(name = inputName, onClear = { inputName = "" })
            },
            label = { Text(text = type)},
            singleLine = true,
            shape = RoundedCornerShape(20),
            textStyle = TextStyle(
                fontSize = 20.sp, fontWeight = FontWeight.Medium
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                cursorColor = Color.Gray,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.Gray
            )
        )
    }

    @Composable
    fun InputGroup(modifier: Modifier=Modifier){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReadTexInput(name = "Digite codigo", type = "DD")
            ReadTexInput(name = "Descrição", type = "DD")
        }
    }


    @Composable
    fun ButtonGroup(modifier: Modifier=Modifier){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonView("Salvar", modifier)
            ButtonView("Cancelar", modifier)
        }
    }

    @Composable
    fun MainCard(modifier: Modifier=Modifier){
        Scaffold(
            topBar = { TopBar() }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                CardBalance(modifier)
                InputGroup(modifier)
                ButtonGroup(modifier)
            }
        }
    }
}