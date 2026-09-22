import kotlin.String

data class Quarto (
    val numero: Int,
    var livre: Boolean = true
) {
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

data class TipoQuarto (
    val tipo: String,
    val fator: Double
)

fun criarReserva() {
    val quartos = (1..20).map { Quarto(it) }.toMutableList()
    val reservas = mutableListOf<Reserva>()

    val entradaHospede: String = readString("Qual é o nome do hospede? ")

    val entradaValorDiaria: Double = readDouble("Qual é o valor da diaria? ", 1.00)

    val entradaQtdDias: Int = readInt("Quantas diarias? (1-30) ", 1)

    val entradaTipoQuarto: TipoQuarto = lerTipoQuarto()

    val entradaNumQuarto = lerNumeroQuarto(quartos)

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
        quarto.livre = false
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
        entrada = readString("Tipo inválido, deve ser (S/E/L) ")
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

    val tipoRetorno = TipoQuarto(tipoEntrada, fatorEntrada)
    return tipoRetorno
}

fun lerNumeroQuarto(quartos: List<Quarto>): Int {
    while (true) {
        val numero = readInt("Selecione um quarto (1-20) ",1, 20)
        val quarto = quartos.find {it.numero == numero}
        print(quarto)
        if (quarto?.letreiro == "L") {
            continue
        } else {
            print("ocupado")
        }
        return numero
    }
}
