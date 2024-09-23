package ia.quantum.quantumpay.data

import ia.quantum.quantumpay.model.Statement

class DataBase {
    fun loadData(): List<Statement>{
        return listOf<Statement>(
            Statement("João Silva", 1500.50.toString(), "Banco do Brasil"),
            Statement("Maria Souza", 3200.00.toString(), "Caixa Econômica"),
            Statement("Carlos Oliveira", 750.80.toString(), "Bradesco"),
            Statement("Ana Lima", 2000.00.toString(), "Itaú"),
            Statement("Pedro Santos", 1800.30.toString(), "Santander"),
            Statement("Beatriz Costa", 2500.00.toString(), "Nubank"),
            Statement("Lucas Pereira", 350.60.toString(), "Banco Inter"),
            Statement("Juliana Mendes", 4200.45.toString(), "BTG Pactual"),
            Statement("Fernando Torres", 1120.15.toString(), "Banco Safra"),
            Statement("Laura Nunes", 610.20.toString(), "Banco do Nordeste"),
            Statement("Gabriel Rocha", 8000.00.toString(), "Next"),
            Statement("Paula Marques", 500.75.toString(), "Original"),
            Statement("Ricardo Moreira", 2700.90.toString(), "Neon"),
            Statement("Patrícia Silva", 900.50.toString(), "PagBank"),
            Statement("Daniel Ferreira", 1900.60.toString(), "XP Investimentos"),
            Statement("Amanda Ribeiro", 7200.10.toString(), "Banco Votorantim"),
            Statement("Fábio Duarte", 1650.80.toString(), "C6 Bank"),
            Statement("Sofia Martins", 450.00.toString(), "ModalMais"),
            Statement("Vinícius Correia", 3300.30.toString(), "Daycoval"),
            Statement("Carla Almeida", 5000.00.toString(), "Mercado Pago")
        )
    }
}