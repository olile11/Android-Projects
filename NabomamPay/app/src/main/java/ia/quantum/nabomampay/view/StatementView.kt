package ia.quantum.nabomampay.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ia.quantum.quantumpay.data.DataBase
import ia.quantum.quantumpay.model.Statement

class StatementView: ComposeScreen {

    @Composable
    fun StatementItem(statement: Statement, modifier: Modifier){
        Card (
            modifier = modifier,
            border = BorderStroke(1.dp, color = Color(0xFF000000)),
            colors = CardDefaults
                .cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary),
        ){
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Enviado", style = MaterialTheme.typography.labelSmall)
                    Text(text = "R$ ${statement.balance}",
                        style = MaterialTheme.typography.labelSmall)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Name", style = MaterialTheme.typography.bodyLarge)
                    Text(text = statement.name, style = MaterialTheme.typography.bodyLarge)
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(text = "Instituição", style = MaterialTheme.typography.bodyLarge)
                    Text(text = statement.institution, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }

    @Composable
    override fun Content(navController: NavController, padding: Modifier) {
        val statementList = DataBase().loadData()
        Scaffold(
            topBar = {BarView().TopBar()},
            bottomBar = {BarView().BottomBar(navController = navController)}
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Balance().CardBalance()
                LazyColumn{
                    items(statementList) { statement ->
                        StatementItem(
                            statement = statement,
                            modifier = Modifier
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}