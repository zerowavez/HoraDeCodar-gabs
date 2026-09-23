data class Hospede (
    var nome: String
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
    } else {
        val hospedeNovo: Hospede = Hospede(nomeHospede)
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
    val listaOrdenada = hospedes
        .sortedBy { it.nome }
        .mapIndexed { index, hospede ->
            "${index + 1}. ${hospede.nome}"
        }.joinToString(separator = "\n")
    println("Todos atualmente hospedados:")
    println(listaOrdenada)
}

fun atualizarCadastro() {

}

fun removerCadastro() {

}