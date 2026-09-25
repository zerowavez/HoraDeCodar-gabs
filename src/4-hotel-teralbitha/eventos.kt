import kotlin.math.ceil
import kotlin.math.floor

data class ReservaEvento (
    val convidados: Int,
    val auditorio: String,
    val dia: String,
    val horaInicial: Int,
    val empresa: String,
    val status: String,
    val qtdBaseGarcons: Int,
    val custoGarcons: Int,
    val ltCafe: Double,
    val ltAgua: Double,
    val qtdSalgados: Int,
    val custoBuffet: Double,
    val total: Double
)

val reservasEventos = mutableListOf<ReservaEvento>()

fun reservaEvento() {
    val auditorio: String
    val qtdCadeiras: Int = readInt("Quantas cadeiras serão necessárias para o evento? (1-350) ",1, 350)
    if (qtdCadeiras < 221) {
        println("O auditório Laranja é mais adequado para o evento!")
        if (qtdCadeiras < 221 && qtdCadeiras > 150) {
            println("Serão necessárias ${qtdCadeiras - 150} cadeiras adicionais")
        }
        auditorio = "Laranja"
    } else {
        auditorio = "Colorado"
    }

    val diasValidos = listOf<String>("segunda", "terça", "quarta", "quinta", "sexta", "sábado", "domingo")
    var diaReserva: String
    do {
        diaReserva = readString("Em que dia acontecerá o evento? ", 1).lowercase()
        if (diaReserva !in diasValidos) {
            println("Esse não é um dia válido. Dias válidos: ${diasValidos.joinToString()}")
        }
    } while (diaReserva !in diasValidos)

    var horaMaximaReserva: Int
    if (diaReserva == "sábado" || diaReserva == "domingo") {
        horaMaximaReserva = 14
    } else {
        horaMaximaReserva = 22
    }

    var horaInicial: Int = 0
    var duracao: Int = 0
    var horaTermino: Int = 0

    while(true) {
        horaInicial = readInt("Que horas o evento começa? (7h - ${horaMaximaReserva}h) ", 7, horaMaximaReserva)

        duracao = readInt("Quanto tempo o evento irá durar? (máximo 12 horas) ", 1, 12)

        horaTermino = horaInicial + duracao

        if (horaTermino > horaMaximaReserva) {
            println("O evento terminaria após o fechamento do auditório (${horaMaximaReserva}h), tente outra duração ou horário...")
            continue
        }

        break
    }

    val nomeEmpresa: String = readString("Qual é o nome da empresa responsável por essa reserva? ",1)

    val qtdBaseGarcons = ceil(qtdCadeiras / 12.0).toInt()

    val reforcoGarcons = floor(duracao / 2.0).toInt()

    val totalGarcons = qtdBaseGarcons + reforcoGarcons

    val valorTotalGarcons = totalGarcons * duracao * 10.50
    println(totalGarcons)

    val qtdSalgados = qtdCadeiras * 7
    val ltsCafe = qtdCadeiras * 0.2
    val ltsAgua = qtdCadeiras * 0.5

    val precoSalgados = qtdSalgados * 0.34
    val precoCafe = ltsCafe * 0.80
    val precoAgua = ltsAgua * 0.40

    val custoTotalBuffet = precoAgua + precoCafe + precoSalgados
    println(custoTotalBuffet)

    println("=================== Resumo da Reserva de Evento ===================")
    println("Empresa: $nomeEmpresa")
    println("Dia: $diaReserva às ${horaInicial}h")
    println("Auditório: $auditorio")
    println("Status da Reserva: Auditório reservado")
    println("-------------------------------------------------------------------")
    println("Número de Convidados: $qtdCadeiras")
    println("Quantidade de Garçons: $qtdBaseGarcons")
    println("Consumo de Café: ${String.format("%.1f", ltsCafe)}L")
    println("Consumo de Água: ${String.format("%.1f", ltsAgua)}L")
    println("Quantidade de Salgados: $qtdSalgados")
    println("-------------------------------------------------------------------")
    println("Custo dos Garçons: R$ ${String.format("%.2f", totalGarcons.toDouble())}")
    println("Custo do Buffet: R$ ${String.format("%.2f", custoTotalBuffet)}")
    println("Total do Evento: R$ ${String.format("%.2f", (totalGarcons + custoTotalBuffet).toDouble())}")
    println("===================================================================")

    val confirmaReserva = readUserOption("$nomeUsuario, confirma a reserva?", "S", "N")
    if (confirmaReserva) {
        val reservaEvento = ReservaEvento (
            convidados = qtdCadeiras,
            auditorio = auditorio,
            dia = diaReserva,
            horaInicial = horaInicial,
            empresa = nomeEmpresa,
            status = "Auditório reservado",
            qtdBaseGarcons = qtdBaseGarcons,
            custoGarcons = totalGarcons,
            ltCafe =ltsCafe,
            ltAgua =ltsAgua,
            qtdSalgados =qtdSalgados,
            custoBuffet =custoTotalBuffet,
            total = (totalGarcons + custoTotalBuffet),
        )
        reservasEventos.add(reservaEvento)
        println("Reserva de evento confirmada!")

        recepcao()
    } else {
        println("Reserva cancelada...")

        recepcao()
    }


}