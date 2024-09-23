package ia.quantum.nabomampay.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ia.quantum.nabomampay.R
import ia.quantum.nabomampay.ui.theme.Montserrat

class ProfileEditView: ComposeScreen {
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
            modifier = modifier
                .width(dimensionResource(id = R.dimen.login_button_dim))
                .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF000000)
            )) {
            Text(
                text = text,
                fontFamily = Montserrat,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
    @Composable
    fun ReadTexInput(name: String, type: String){
        var inputName by remember { mutableStateOf("") }
        OutlinedTextField(
            value = inputName,
            onValueChange = { inputName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            trailingIcon = {
                Eraser(name = inputName, onClear = { inputName = "" })
            },
            label = { Text(text = type)},
            singleLine = true,
            shape = RoundedCornerShape(20),
            textStyle = TextStyle(
                fontSize = 20.sp, fontWeight = FontWeight.Medium
            )
        )
    }


    @Composable
    fun EditUserInformation(modifier: Modifier = Modifier){
        Column(
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.padding_small))
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Dados Pessoais",
                    fontFamily = Montserrat,
                    style = MaterialTheme.typography.displayMedium)
            }
            Column {
                ReadTexInput(name = "Name", type = "Name")
                ReadTexInput(name = "Name", "CPF")
                ReadTexInput(name = "Name", "Data de Nascimento")
                ReadTexInput(name = "Name", "Endereço")
                ReadTexInput(name = "Mãe", "Mãe")
                ReadTexInput(name = "Pai", "Pai")
                Spacer(modifier = modifier.padding(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ButtonView("Salvar", modifier)
                    ButtonView("Cancelar", modifier)
                }
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
                    EditUserInformation()
                }
            }
        }
    }
}