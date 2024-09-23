package ia.quantum.nabomampay.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ia.quantum.nabomampay.R
import ia.quantum.nabomampay.ui.theme.Montserrat

class LoginView: ComposeScreen {

    @Composable
    fun IconUser(modifier: Modifier = Modifier){
        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.user_size))
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.icons8_user_100),
            contentDescription = null
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun InputCard(modifier: Modifier = Modifier){
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
                    text = "Username",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(
                            vertical = dimensionResource(id = R.dimen.padding_small))
                )
                OutlinedTextField(
                    value = usernameInput,
                    onValueChange = {usernameInput = it},
                    label = { Text(text = "Username")},
                    singleLine = true,
                    shape = RoundedCornerShape(20),
                    textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 2.dp, color = Color.Black,
                            shape = RoundedCornerShape(20)
                        )
                )
            }

            Column(
                modifier=modifier
                    .padding(vertical = dimensionResource(id = R.dimen.padding_medium))
            ) {
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(vertical = dimensionResource(id = R.dimen.padding_small))
                )
                OutlinedTextField(
                    value = passwordInput,
                    onValueChange = {passwordInput=it},
                    label = { Text(text = "Password")},
                    singleLine = true,
                    shape = RoundedCornerShape(20),
                    visualTransformation = PasswordVisualTransformation(),
                    textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 2.dp, color = Color.Black,
                            shape = RoundedCornerShape(20)
                        )
                )
            }
        }
    }

    @Composable
    fun ButtonCard(navController: NavController, modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navController.navigate("home") },
                shape = RoundedCornerShape(20),
                modifier = modifier
                    .width(dimensionResource(id = R.dimen.login_button_dim)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000)
                )) {
                Text(
                    text = "Login",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(R.dimen.padding_small))
                )
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(20),
                modifier = modifier
                    .width(dimensionResource(id = R.dimen.login_button_dim)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF000000)
                )) {
                Text(
                    text = "Sign",
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(vertical = dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
    @Composable
    override fun Content(navController: NavController, padding: Modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = dimensionResource(id = R.dimen.padding_medium),
                    horizontal = dimensionResource(id = R.dimen.padding_small)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            IconUser(Modifier)
            InputCard(Modifier)
            ButtonCard(navController, Modifier)
        }
    }
}