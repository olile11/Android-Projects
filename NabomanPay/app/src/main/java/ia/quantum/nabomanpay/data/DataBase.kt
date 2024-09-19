package ia.quantum.quantumpay.data

import ia.quantum.quantumpay.model.Extract

class DataBase {
    fun loadData(): List<Extract>{
        return listOf<Extract>(
            Extract("João Silva", 1500.50.toString(), "Banco do Brasil"),
            Extract("Maria Souza", 3200.00.toString(), "Caixa Econômica"),
            Extract("Carlos Oliveira", 750.80.toString(), "Bradesco"),
            Extract("Ana Lima", 2000.00.toString(), "Itaú"),
            Extract("Pedro Santos", 1800.30.toString(), "Santander"),
            Extract("Beatriz Costa", 2500.00.toString(), "Nubank"),
            Extract("Lucas Pereira", 350.60.toString(), "Banco Inter"),
            Extract("Juliana Mendes", 4200.45.toString(), "BTG Pactual"),
            Extract("Fernando Torres", 1120.15.toString(), "Banco Safra"),
            Extract("Laura Nunes", 610.20.toString(), "Banco do Nordeste"),
            Extract("Gabriel Rocha", 8000.00.toString(), "Next"),
            Extract("Paula Marques", 500.75.toString(), "Original"),
            Extract("Ricardo Moreira", 2700.90.toString(), "Neon"),
            Extract("Patrícia Silva", 900.50.toString(), "PagBank"),
            Extract("Daniel Ferreira", 1900.60.toString(), "XP Investimentos"),
            Extract("Amanda Ribeiro", 7200.10.toString(), "Banco Votorantim"),
            Extract("Fábio Duarte", 1650.80.toString(), "C6 Bank"),
            Extract("Sofia Martins", 450.00.toString(), "ModalMais"),
            Extract("Vinícius Correia", 3300.30.toString(), "Daycoval"),
            Extract("Carla Almeida", 5000.00.toString(), "Mercado Pago")
        )
    }
}