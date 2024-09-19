package ia.quantum.nabomanpay.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import ia.quantum.quantumpay.model.Extract


class ReportView {

    @Composable
    fun ReportCard(extract: Extract, modifier: Modifier){
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
    fun ReportList(extractList: List<Extract>){
        Column() {
            LazyColumn() {
                items(extractList) { extract ->
                    ReportCard(
                        extract = extract,
                        modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
            }
        }
    }

//    @Preview(showBackground = true)
//    @Composable
//    fun ExtractCardPreview(){
//        QuantumpayTheme {
//            val extract = Extract(
//                "Candido", "500.00",
//                "Banco do Brazil")
//            ExtractCard(extract, Modifier.padding(16.dp))
//        }
//    }
}