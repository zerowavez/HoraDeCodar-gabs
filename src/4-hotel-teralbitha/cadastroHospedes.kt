data class Hospede (
    val nome: String
)

private var hospedes = mutableListOf<Hospede>()

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
    var nomeHospede: String = readString("Insira o nome do hospede: ", 1)
}

fun pesquisarExato() {

}

fun pesquisarPrefixo() {

}

fun listarOrdenado() {

}

fun atualizarCadastro() {

}

fun removerCadastro() {

}