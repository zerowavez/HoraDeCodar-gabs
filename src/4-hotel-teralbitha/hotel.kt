import kotlin.system.exitProcess

val nomeHotel: String = "Usona"
var nomeUsuario: String = "Pililiu"

fun main() {
    // nomeUsuario = readString("Bem vindo ao Hotel $nomeHotel!, qual é seu nome? ", 1)

    if (autenticarHospede(nomeUsuario, true)) {
        recepcao()
    }
}

fun recepcao() {
    // função sendo testada:
    // criarReserva()

    print("Bem vindo ao Hotel $nomeHotel!\n")
    // A varival escolha armazena a opção escolhida pelo usuário.
    // uma variavel local é utilizada apenas dentro da função recepcao().
    val escolha = readInt("Escolha uma opção:", 1, 5)
    when (escolha) {
        1 -> criarReserva()
        2 -> CadastroHospedesDataClass()
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