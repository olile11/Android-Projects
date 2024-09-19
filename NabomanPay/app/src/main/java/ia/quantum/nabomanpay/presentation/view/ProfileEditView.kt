package ia.quantum.nabomanpay.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
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
import ia.quantum.nabomanpay.R
import ia.quantum.nabomanpay.theme.Montserrat

class ProfileEditView {

    @Composable
    fun UserCard(modifier: Modifier = Modifier){
        Card(
            modifier = Modifier.padding(horizontal = 8.dp),
            shape = RoundedCornerShape(16.dp, 16.dp),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary),
            border = BorderStroke(1.dp, color = Color(0xFF000000))
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.image_size))
                        //.padding(dimensionResource(R.dimen.padding_small))
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.bella),
                    contentDescription = null
                )
                Text(text = "Da vince Demon",
                    fontFamily = Montserrat,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(4.dp))
                Text(text = "Conta",
                    fontFamily = Montserrat,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(4.dp))
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
                .width(dimensionResource(id = R.dimen.login_button_dim)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF)
            )) {
            Text(
                text = text,
                color = Color.Black,
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
                .fillMaxWidth()
                .padding(4.dp),
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
    fun EditUserInformation(modifier: Modifier = Modifier){
        Column(
            modifier = modifier.padding(horizontal = 8.dp)
                .fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Dados Pessoais",
                    fontFamily = Montserrat,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp)
                Image(
                    modifier = modifier
                        .size(50.dp)
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.icons8_edit_profile_30),
                    contentDescription = null
                )
            }
            HorizontalDivider(thickness = 4.dp,
                color = Color(0xFFFFFFFF))
            Column {
                ReadTexInput(name = "Name", type = "Name")
                HorizontalDivider(thickness = 2.dp,
                    color = Color(0xFFFFFFFF))
                ReadTexInput(name = "Name", "CPF")
                HorizontalDivider(thickness = 2.dp,
                    color = Color(0xFFFFFFFF))
                ReadTexInput(name = "Name", "Birth")
                HorizontalDivider(thickness = 2.dp,
                    color = Color(0xFFFFFFFF))
                ReadTexInput(name = "Name", "distric")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ButtonView("Salvar", modifier)
                ButtonView("Cancelar", modifier)
            }
        }
    }

    @Composable
    fun Profile(modifier: Modifier = Modifier){
        Column(
            modifier = modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            UserCard(modifier)
            Card(
                modifier = Modifier.padding(horizontal = 8.dp),
                shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.Black)
            ){
                EditUserInformation(modifier)
                //EditParentInformation(modifier)
            }

        }
    }
}