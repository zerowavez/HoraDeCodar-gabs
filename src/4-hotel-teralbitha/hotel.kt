val nomeHotel: String = "Usona"
var nomeUsuario: String = "Pililiu"

fun main() {
    // nomeUsuario = readString("Bem vindo ao Hotel $nomeHotel!, qual é seu nome? ", 1)

    if (autenticarUsuario(nomeUsuario, true)) {
        recepcao()
    }
}

fun recepcao() {
    // função sendo testada:
    // criarReserva()

    println("==================== Hotel $nomeHotel ====================")
    println("""
        |1 - Reservar Um Quarto
        |2 - Gerenciamento De Hospedes
        |3 - Gerenciamento De Eventos
        |4 - Abastecimento De Veículos
        |5 - Manutenção Do Ar Condicionado
        |6 - Relatórios
        |7 - Check-out
    """.trimMargin())

    val escolha = readInt("Escolha uma opção:", 1, 7)
    when (escolha) {
        1 -> criarReserva()
        2 -> submenuHospedes()
        3 -> print("eventos!")
        4 -> AbastecimentoDeAutomoveis()
        5 -> print("ar condicionado!")
        6 -> print("relatórios!")
        7 -> sairDoHotel()
        else -> erro()
    }
}

fun AbastecimentoDeAutomoveis() {
    TODO()
}

fun erro(){
    println("Por favor, informe um número entre 1 e 4.")
    recepcao()
}

fun sairDoHotel() {
    val confirma = readUserOption("Você deseja sair?", "S", "N")
    if (confirma) {
        println("Até logo!")
    } else {
        recepcao()
    }
}