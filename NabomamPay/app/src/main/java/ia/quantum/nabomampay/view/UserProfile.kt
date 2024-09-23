package ia.quantum.nabomampay.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import ia.quantum.nabomampay.R

class UserProfile {
    @Composable
    fun UserCard(modifier: Modifier = Modifier){
        Card(
            modifier = Modifier
                .height(100.dp)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_medium)),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary),
            border = BorderStroke(1.dp, color = Color(0xFF000000))
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.bella),
                    contentDescription = null
                )
                Text(text = "Da vince Demon",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = modifier
                        .padding(dimensionResource(id = R.dimen.padding_small)))
            }
        }
    }
}