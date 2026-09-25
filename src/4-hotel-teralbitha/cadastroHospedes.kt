import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class Hospede (
    var nome: String,
    var dataCadastro: String?,
    var horaCadastro: String?,
)

var hospedes = mutableListOf<Hospede>()

fun submenuHospedes() {
    println("""
        ================== Submenu Hospedes ==================
        1-Cadastrar
        2-Pesquisar exato
        3-Pesquisar prefixo
        4-Listar
        5-Atualizar
        6-Remover
        7-Voltar
    """.trimIndent())
    val opcao: Int = readInt("Selecione uma das opções acima: ", 1, 7)

    when (opcao) {
        1 -> cadastrarHospede()
        2 -> pesquisarExato()
        3 -> pesquisarPrefixo()
        4 -> listarOrdenado()
        5 -> atualizarCadastro()
        6 -> removerCadastro()
        7 -> recepcao()
        else -> recepcao()
    }
}

fun cadastrarHospede() {
    val nomeHospede: String = readString("Insira o nome do hospede: ", 1).replaceFirstChar { it.uppercase() }
    if (hospedes.size > 15) {
        println("O hotel está cheio, volte mais tarde!")
    } else if (hospedes.any { it.nome == nomeHospede }) {
        println("Hospede com esse exato mesmo nome já registrado...")
    } else {
        val horaAtual: LocalTime = LocalTime.now()
        val formatadorHora = DateTimeFormatter.ofPattern("HH:mm:ss")
        val horaFormatada = horaAtual.format(formatadorHora)

        val dataAtual: LocalDate = LocalDate.now()
        val formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val dataFormatada = dataAtual.format(formatadorData)

        val hospedeNovo: Hospede = Hospede(
            nomeHospede,
            dataFormatada,
            horaFormatada
        )
        hospedes.add(hospedeNovo)
        println("Hospede adicionado com sucesso!")
    }

    submenuHospedes()
}

fun pesquisarExato() {
    val consulta: String = readString("Escreva o exato nome pelo qual quer pesquisar: ", 1).replaceFirstChar { it.uppercase() }
    val hospedeConsultado: Hospede? = hospedes.find { it.nome == consulta }
    if (hospedeConsultado?.nome?.isNotEmpty() == true) {
        println("Hospede $consulta está atualmente hospedado!")

    } else {
        println("Hospede $consulta parece não estar hospedado...")
    }

    submenuHospedes()
}

fun pesquisarPrefixo() {
    val consulta: String = readString("Escreva o prefixo pelo qual quer pesquisar: ", 1).replaceFirstChar { it.uppercase() }
    val hospedesEncontrados: List<Hospede> = hospedes.filter { it.nome.startsWith(consulta, ignoreCase = true) }
    if (hospedesEncontrados.isNotEmpty()) {
        val listaFormatada = hospedesEncontrados
            .sortedBy { it.nome }
            .mapIndexed { index, hospede ->
                "${index + 1}. ${hospede.nome}"
            }.joinToString(separator = "\n")
        println("Hóspedes encontrados com o prefixo '$consulta':")
        println(listaFormatada)
    } else {
        println("Nenhum hospede com o prefixo $consulta encontrado...")
    }

    submenuHospedes()
}

fun listarOrdenado() {
    if (hospedes.isNotEmpty()) {
        val listaOrdenada = hospedes
            .sortedBy { it.nome }
            .mapIndexed { index, hospede ->
                "${index + 1}. ${hospede.nome} - ${hospede.dataCadastro} - ${hospede.horaCadastro}"
            }.joinToString(separator = "\n")
        println("Todos atualmente hospedados:")
        println(listaOrdenada)
    } else {
        println("Nenhum hospede está registrado no momento...")
    }

    submenuHospedes()
}

fun atualizarCadastro() {
    val numIndice: Int = readInt("Digite o indice do hospede que deseja atualizar ",1, hospedes.size + 1)
    val nomeAtualizado: String = readString("Digite o nome atualizado para o hospede ", 1).replaceFirstChar { it.uppercase() }
    hospedes[numIndice -1].nome = nomeAtualizado

    println("Nome do hospede atualizado!")
    submenuHospedes()
}

fun removerCadastro() {
    val numIndice: Int = readInt("Digite o indice do hospede que deseja remover da lista ",1, hospedes.size + 1)
    println("Hospede: ${hospedes[numIndice -1].nome} de indice $numIndice foi removido da lista!")
    hospedes -= hospedes[numIndice -1]

    submenuHospedes()
}