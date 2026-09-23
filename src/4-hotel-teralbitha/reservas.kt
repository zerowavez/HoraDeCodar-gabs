import kotlin.String

data class Quarto (
    val numero: Int,
    var livre: Boolean = true
) {
    // função get permite passar um valor dinâmico dependendo de uma condicional
    val letreiro: String
        get() = if (livre) "L" else "O"
}

data class Reserva (
    val hospede: String,
    val quarto: Int,
    val diarias: Int,
    val valorDiaria: Double,
    val tipoQuarto: String,
    val fator: Double,
    val subtotal: Double,
    val taxaServico: Double,
    val total: Double
)

// poupa de ter que criar duas variáveis separadas para tipo e fator
data class TipoQuarto (
    val tipo: String,
    val fator: Double
)

// map automaticamente cria 20 entradas numeradas automaticamente
// deve ser global para que possa ser acessado nas demais funções desse programa
val quartos = (1..20).map { Quarto(it) }.toMutableList()

// deve ser global por conta do subprograma de relatórios
val reservas = mutableListOf<Reserva>()

fun criarReserva() {
    // entradas simples
    val entradaHospede: String = readString("Qual é o nome do hospede? ", 1)

    val entradaValorDiaria: Double = readDouble("Qual é o valor da diaria? ", 1.00)

    val entradaQtdDias: Int = readInt("Quantas diarias? (1-30) ", 1)

    // entradas que já requerem sua própria função
    val entradaTipoQuarto: TipoQuarto = lerTipoQuarto()

    val entradaNumQuarto = lerNumeroQuarto(quartos)

    // processamento
    val subtotal = entradaValorDiaria * entradaQtdDias * entradaTipoQuarto.fator
    val taxaServico = subtotal * 0.10
    val total = subtotal + taxaServico

    println("==================== Resumo da Reserva ====================")
    println("Nome do hospede: $entradaHospede")
    println("Quarto: $entradaNumQuarto (${entradaTipoQuarto.tipo})")
    println("Valor da diária: R\$ ${String.format("%.2f", entradaValorDiaria)}")
    println("Subtotal: R\$ ${String.format("%.2f", subtotal)}")
    println("Taxa de serviço (10%): R\$ ${String.format("%.2f", taxaServico)}")
    println("Total: R\$ ${String.format("%.2f", total)}")

    val confirmaReserva = readUserOption("$nomeUsuario, confirma a reserva?", "S", "N")
    if (confirmaReserva) {
        val quarto = quartos.find { it.numero == entradaNumQuarto }!!
        quarto.livre = false // preenche quarto
        println("Reserva efetuada!")

        val reserva = Reserva(
            hospede = entradaHospede,
            quarto = entradaNumQuarto,
            diarias = entradaQtdDias,
            valorDiaria = entradaValorDiaria,
            tipoQuarto = entradaTipoQuarto.tipo,
            fator = entradaTipoQuarto.fator,
            subtotal = subtotal,
            taxaServico = taxaServico,
            total = total
        )
        reservas.add(reserva)

        recepcao()
    } else {
        println("Reserva não efetuada...")

        recepcao()
    }
}

fun lerTipoQuarto(): TipoQuarto {
    var entrada = readString("Qual é o tipo do quarto? (S/E/L) ", 1, 1).uppercase()
    if (entrada !in "SEL") {
        entrada = readString("Tipo inválido, deve ser (S/E/L) ", 1, 1).uppercase()
    }
    val tipoEntrada = when(entrada) {
        "S" -> "Padrão"
        "E" -> "Executivo"
        "L" -> "Luxuoso"
        else -> "Padrão"
    }

    val fatorEntrada = when (entrada) {
        "S" -> 1.00
        "E" -> 1.35
        "L" -> 1.65
        else -> 1.00
    }

    // monta nosso objeto tipo quarto e o retorna
    val tipoRetorno = TipoQuarto(tipoEntrada, fatorEntrada)
    return tipoRetorno
}

// precisa de lista de quartos como parâmetro para percorrer e identificar ocupação
fun lerNumeroQuarto(quartos: List<Quarto>): Int {
    while (true) {
        val numero = readInt("Selecione um quarto (1-20) ",1, 20)
        // precisamos encontrar o quarto específico para aplicar os checks
        val quarto = quartos.find {it.numero == numero}
        // debug println("!!!!!!!!!!! $quarto !!!!!!!!!!!!!")
        if (quarto != null && quarto.letreiro == "O") {
            println("Quarto $numero está ocupado! Escolha um dos seguintes quartos livres: ")
            listarQuartosLivres(quartos)
            continue
        }

        return numero
    }
}

fun listarQuartosLivres(quartos: List<Quarto>) {
    // caso não tiverem quartos livre
    if (quartos.none { it.letreiro == "L" }) {
        println("O hotel está cheio, volte novamente mais tarde...")
        recepcao()
    } else {
        // chunked divide a lista em diferentes partes, no nosso caso, 4 listas de 5 quartos
        val linhaQuartos = quartos.chunked(5)
        // laço que vai imprimir as 4 listas
        for (linha in linhaQuartos) {
            // laço que vai imprimir as linhas
            for (quarto in linha) {
                // string.format torna 9 em 09, por exemplo, deixa uniforme
                print("[${String.format("%02d", quarto.numero)}: ${quarto.letreiro}]")
            }
            // quebra de linha
            println()
        }
    }
}
