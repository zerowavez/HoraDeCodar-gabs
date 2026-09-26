fun exibirRelatorio() {
    println("Total de reservas de quartos confirmadas: ${reservas.size}")

    val totalQuartosLivres = mutableListOf<Quarto>()
    for (quarto in quartos) {
        if (quarto.livre) {
            totalQuartosLivres += quarto
        }
    }
    println("Taxa de ocupação atual: ${totalQuartosLivres.size / 20}")

    println("Quantidade de hospedes cadastrados: ${hospedes.size}")

    println("Quantidade de eventos confirmados: ${reservasEventos.size}")

    val totalHospedagem: Double = reservas.sumOf { it.total }
    val totalEventos: Double = reservasEventos.sumOf { it.total }

    println("Receita acumulada:")
    println("Hospedagem: R$${String.format("%.2f",totalHospedagem)}")
    println("Eventos: R$${String.format("%.2f",totalEventos)}")
    println("Total geral: R$${String.format("%.2f",totalHospedagem + totalEventos)}")
}