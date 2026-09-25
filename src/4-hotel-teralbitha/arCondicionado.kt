data class Empresa(
    val nomeEmpresa: String,
    val valorAparelho: Double,
    val qtdAparelhos: Int,
    val desconto: Double,
    val minimoDesconto: Int,
    val valorDeslocamento: Double,
    val total: Double
)

var empresas = mutableListOf<Empresa>()

fun manutencaoCondicionado() {
    val empresa: String = readString("Insira o nome da empresa: ", 1).replaceFirstChar { it.uppercase() }

    val valorAparelho: Double = readDouble("Quanto custa o serviço por aparelho? (em R$) ", 1.00)

    val qtdAparelhos: Int = readInt("Quantos aparelhos precisam de manutenção? ", 1)

    val desconto: Double = readDouble("Qual é o percentual de desconto oferecido pela empresa? ", 0.00, 99.00)

    val minimoDesconto: Int = readInt("Qual é a quantidade mínima de aparelhos elegível para o desconto? ", 1)

    val valorDeslocamento: Double = readDouble("Quanto a empresa cobra para se deslocar até o hotel? ", 1.00)

    var total: Double = valorAparelho * qtdAparelhos + valorDeslocamento
    if (qtdAparelhos >= minimoDesconto) {
        total -= desconto
    }

    val novaEmpresa = Empresa(
        nomeEmpresa = empresa,
        valorAparelho = valorAparelho,
        qtdAparelhos = qtdAparelhos,
        desconto = desconto,
        minimoDesconto = minimoDesconto,
        valorDeslocamento = valorDeslocamento,
        total = total
    )
    empresas.add(novaEmpresa)

    println("==================== Resumo do Serviço ====================")
    println("Nome da empresa: ${novaEmpresa.nomeEmpresa}")
    println("Aparelhos em manutenção: ${novaEmpresa.qtdAparelhos}")
    println("Valor por aparelho: R$ ${String.format("%.2f", novaEmpresa.valorAparelho)}")
    println("Valor do deslocamento: R$ ${String.format("%.2f", novaEmpresa.valorDeslocamento)}")
    println("Desconto oferecido: ${novaEmpresa.desconto}% (mínimo de ${novaEmpresa.minimoDesconto} aparelhos)")
    println("Total: R$ ${String.format("%.2f", novaEmpresa.total)}")

    val opcao = readUserOption("Deseja informar outra empresa, $nomeUsuario?", "S", "N")
    if (!opcao) {
        recepcao()
    }

    println("O melhor orçamento foi o de empresa")

}
