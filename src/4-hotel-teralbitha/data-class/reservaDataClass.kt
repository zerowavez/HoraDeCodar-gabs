data class reservaDataClass (
    var valorDiaria: Int,
    var quantidadeDias : Int,
    var nomeHospede: String,
    var tipoQuarto: String,
    var numQuarto: Int
)

data class resumoDataClass (
    var nomeHospede: String,
    var numQuarto: Int,
    var subtotal: Double,
    var taxaServico: Double,
    var total: Double
)

fun criarReserva() {
    val validarQuartos: String = "SEL" // para verificação de tipo válido

    //- entradas do usuário ------------------------------------------

    val entradaDiaria: Int = readInt("Informe o valor da diária ", 1)
    val entradaDias: Int = readInt("Informe a quantidade de diárias (1-30) ", 1, 30)
    val entradaHospede: String = readString("Informe o nome do hóspede ", 1)

    var entradaQuarto: String = readString("Tipo de quarto (S/E/L) ",1, 1).uppercase()
    if (!entradaQuarto.any { it in validarQuartos}) {
        while (true) {
            entradaQuarto = readString("Tipo inserido não existe, digite um tipo válido (S/E/L) ",1, 1).uppercase()
            if (entradaQuarto.any { it in validarQuartos}) {
                break
            } else {
                continue
            }
        }
    } // p.s. odeio aninhar funções

    val entradaTipoQuarto: String = when(entradaQuarto) {
        "S" -> "Padrão"
        "E" -> "Executivo"
        "L" -> "Luxuoso"
        else -> "???" // hah, like that's ever gonna happen
    }

    val fator = when (entradaQuarto) {
        "S" -> 1.00
        "E" -> 1.35
        "L" -> 1.65
        else -> 0.00 // hah, like that's ever gonna happen
    }

    var entradaNumQuarto: Int = readInt("Escolha um quarto (1-20) ")
//  if (numQuarto is ocupado) {
//    bibibibobobob implementar solução aqui dps
//  }

    val reserva = reservaDataClass(
        valorDiaria = entradaDiaria,
        quantidadeDias = entradaDias,
        nomeHospede = entradaHospede,
        tipoQuarto = entradaTipoQuarto,
        numQuarto = entradaNumQuarto
    )

    //- processamento --------------------------------------------

    val subtotalEntradas: Double = entradaDiaria * entradaDias * fator
    val taxaServicoEntradas: Double = subtotalEntradas / 10// vulgo 10%
    val totalEntradas: Double = subtotalEntradas + taxaServicoEntradas

    val resumo = resumoDataClass(
        nomeHospede = entradaHospede,
        numQuarto = entradaNumQuarto,
        subtotal = subtotalEntradas,
        taxaServico = taxaServicoEntradas,
        total = totalEntradas
    )

    //- confirmação -----------------------------------------------

    println("""
        Resumo:
        Hóspede: ${resumo.nomeHospede}
        Quarto: ${resumo.numQuarto} (${reserva.tipoQuarto})
        Subtotal: ${resumo.subtotal}
        Taxa de serviço (10%): ${resumo.taxaServico}
        Total: ${resumo.total}
    """.trimIndent())

    val confirma = readUserOption("$nomeUsuario, confirma a reserva?", "S", "N")
    if (confirma) {
        println("Reserva confirmada com sucesso!")
    } else (
        println("Reserva cancelada...")
    )
}