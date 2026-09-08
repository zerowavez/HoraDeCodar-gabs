import kotlin.system.exitProcess

var saldo: Double = 100.5 // agora é double
var nome: String = "fulano" // ini

fun main() {
    nome = readString("Para começar digite seu nome: ")
    println("Olá $nome é um prazer ter você por aqui!")

    inicio()
}

fun inicio() {
    println("1 - Ver saldo")
    println("2 - Ver extrato")
    println("3 - Fazer depósito")
    println("4 - Fazer saque")
    println("5 - Fazer transferência")
    println("6 - Sair")
    val escolha = readInt("Escolha uma dessas opções: ", 1, 6)

    when (escolha) {
        1 -> verSaldo()
        2 -> verExtrato()
        3 -> fazerDeposito()
        4 -> fazerSaque()
        5 -> fazerTransferencia()
        6 -> sair()
    }
}

fun verSaldo() {
    autenticar()

    println("Seu saldo atual é: $saldo")
    inicio()
}

fun fazerDeposito() {
    val deposito = readDouble("Qual o valor para depósito? ", 1.00, saldo)
    // Usando readln e Elvis operator -> Operador de coalescência nula
    // val deposito = readln().toFloatOrNull() ?: 0.0

    if (deposito == null) {
        println("Por favor, informe um número válido.")
        fazerDeposito()
    } else {
        saldo += deposito
        verSaldo()
    }
}

fun fazerSaque() {
    autenticar()

    val saque = readDouble("Qual o valor para saque? ", 1.00, saldo)

    if (saque == null) {
        println("Por favor, informe um número válido.")
        fazerSaque()
    } else {
        saldo -= saque
        verSaldo()
    }
}

fun verExtrato() {
    autenticar()

    println("Caneta Bic Azul (Edição Manoel Gomes)")
    println("R$109,99 - 19/08/26 às 23:99h")

    println("------------------------------")

    println("Autógrafo da Microcelebridade Lorena, Famosa Pelo Meme: Hi Loreeena")
    println("R$350,01 - 12/03/25 às 00:13h")

    println("------------------------------")

    println("Pix Do Milhão ")
    println("R$1000,00 - 01/01/25 às 01:01h")
}

fun fazerTransferencia() {
    var numConta = readInt("Para qual conta será feita a transferência? ", 1)

    var valorTransf = readDouble("Quanto você quer transferir para a conta $numConta?", 1.0, saldo)

    saldo -= valorTransf
}

fun autenticar() {
    var senha = readInt("Para continuar informe sua senha: ", 1)
    if (senha == 3589) {
        println("Autenticado! continuando...")
    } else {
        println("Senha incorreta, voltando...")
        inicio()
    }
}

fun sair() {
    // Usando readln e Elvis operator -> Operador de coalescência nula
    val confirma = readUserOption("Você deseja sair?", "S", "N")
    // Locale -> Localização do usuário para converter para maiúsculo
    //val confirma = readLine()?.uppercase(Locale.getDefault())

    when (confirma) {
        true -> {println("$nome, foi um prazer ter você por aqui!")
            exitProcess(0)}//Hasta la vista, baby
        false -> inicio() // Volta para o início
    }
}