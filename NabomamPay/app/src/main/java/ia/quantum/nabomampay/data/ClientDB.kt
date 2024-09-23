package ia.quantum.nabomampay.data

import ia.quantum.nabomampay.R
import ia.quantum.nabomampay.domain.Client

class ClientDB {
    fun loadData(): List<Client>{
        return listOf<Client>(
            Client(R.drawable.image1, "Maria Souza", 45, "Ciclista"),
            Client(R.drawable.image2, "Tomas Muller", 28, "Arbitragem"),
            Client(R.drawable.image3, "Donato Bakale", 34,"Escalar Montanha"),
            Client(R.drawable.image5, "Claudia Schaineider", 32, "Futeboll"),
        )
    }
}