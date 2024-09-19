package ia.quantum.nabomanpay.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ia.quantum.nabomanpay.R
import ia.quantum.nabomanpay.theme.Montserrat

class ProfileView (private val navController: NavController): ComposeScreen {

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
    fun UserInformation(modifier: Modifier = Modifier){
        Column(
            modifier = modifier.padding(horizontal = 8.dp)
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
                Text(text = "Da vince",
                    color = Color.White,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp))
                HorizontalDivider(thickness = 2.dp,
                    color = Color(0xFFFFFFFF))
                Text(text = "713.854.768-12",fontFamily = Montserrat,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp))
                HorizontalDivider(thickness = 2.dp,
                    color = Color(0xFFFFFFFF))
                Text(text = "25/12/2000",fontFamily = Montserrat,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp))
                HorizontalDivider(thickness = 2.dp,
                    color = Color(0xFFFFFFFF))
                Text(text = "50355-45, Tabuleiro",fontFamily = Montserrat,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    fun ParentInformation(modifier: Modifier = Modifier){
        Column{
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Filhação",fontFamily = Montserrat,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 8.dp))
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
            Column(
                modifier = modifier.padding(horizontal = 8.dp)
            ) {
                Text(text = "Namirana Bebe",
                    color = Color.White,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp))
                HorizontalDivider(thickness = 2.dp,
                    color = Color(0xFFFFFFFF))
                Text(text = "Gau Bishop",fontFamily = Montserrat,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp))
            }
        }
    }


    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            UserCard(Modifier)
            Card(
                modifier = Modifier.padding(horizontal = 8.dp),
                shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.Black)
            ){
                UserInformation(Modifier)
                ParentInformation(Modifier)
            }

        }
    }
}