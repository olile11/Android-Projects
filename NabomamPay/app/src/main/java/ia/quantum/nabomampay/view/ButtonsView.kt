package ia.quantum.nabomampay.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ia.quantum.nabomampay.R

class ButtonsView {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PayInputCard(navController: NavController, modifier: Modifier = Modifier){
        var usernameInput by remember {
            mutableStateOf("")
        }
        var passwordInput by remember {
            mutableStateOf("")
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Column {
                Text(
                    text = "Codigo de Barra",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(
                            vertical = dimensionResource(id = R.dimen.padding_small)
                        )
                )
                OutlinedTextField(
                    value = usernameInput,
                    onValueChange = {usernameInput = it},
                    label = { Text(text = "Digite o codigo") },
                    singleLine = true,
                    shape = RoundedCornerShape(20),
                    textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            Column(
                modifier=modifier
                    .padding(vertical = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(
                    text = "Descrição",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(vertical = dimensionResource(id = R.dimen.padding_small))
                )
                OutlinedTextField(
                    value = passwordInput,
                    onValueChange = {passwordInput=it},
                    label = { Text(text = "Digite a descrição") },
                    singleLine = true,
                    shape = RoundedCornerShape(20),
                    textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

    }

    @Composable
    fun ButtonGroup(navController: NavController, modifier: Modifier = Modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Button(
                onClick = { navController.navigate("done") },
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )) {
                Text(text = "Pagar",
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
            Spacer(
                modifier = modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_medium)))
            Button(
                onClick = { navController.navigate("pay") },
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )) {
                Text(text = "Leitor de Codigo",
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}