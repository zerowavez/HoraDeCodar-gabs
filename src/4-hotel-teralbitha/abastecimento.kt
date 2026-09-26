import java.util.Locale

data class PostoGasolina (
    val nomePosto: String,
    val valorGasolina: Double,
    val valorEtanol: Double,
)

fun consultarPrecosGas() {
    var valorGas: Double = readDouble("Quanto está custando a gasolina no posto Stark Petrol? ", 1.00)
    var valorAlcool: Double = readDouble("E quanto está custando o álcool no posto Stark Petrol? ", 1.00)

    val starkPetrol = PostoGasolina(
        nomePosto = "Stark Petrol",
        valorGasolina = valorGas,
        valorEtanol = valorAlcool
    )

    valorGas = readDouble("Quanto está custando a gasolina no posto Wayne Oil? ", 1.00)
    valorAlcool = readDouble("E quanto está custando o álcool no posto Wayne Oil? ", 1.00)

    val wayneOil = PostoGasolina(
        nomePosto = "Wayne Oil",
        valorGasolina = valorGas,
        valorEtanol = valorAlcool
    )

    val localeBR = Locale("pt", "BR")
    val litragem = 42.0

    fun formatarPrecos(posto: PostoGasolina) {
        val etanolStr = String.format(localeBR, "%.2f", posto.valorEtanol)
        val gasolinaStr = String.format(localeBR, "%.2f", posto.valorGasolina)
        println("${posto.nomePosto} -> Álcool: $etanolStr | Gasolina: $gasolinaStr")
    }

    println()
    formatarPrecos(wayneOil)
    formatarPrecos(starkPetrol)
    println()

    fun obterDadosCenariao(posto: PostoGasolina): Pair<String, Double> {
        val melhorOpcao = if (posto.valorEtanol <= posto.valorGasolina * 0.70) "Álcool" else "Gasolina"
        val precoEscolhido = if (melhorOpcao == "Álcool") posto.valorEtanol else posto.valorGasolina
        val totalCusto = precoEscolhido * litragem
        return Pair(melhorOpcao, totalCusto)
    }

    val (opcaoWayne, custoWayne) = obterDadosCenariao(wayneOil)
    val (opcaoStark, custoStark) = obterDadosCenariao(starkPetrol)

    println("${wayneOil.nomePosto}: melhor opção = $opcaoWayne | Total (42L) = R$ ${String.format(localeBR, "%.2f", custoWayne)}")
    println("${starkPetrol.nomePosto}: melhor opção = $opcaoStark | Total (42L) = R$ ${String.format(localeBR, "%.2f", custoStark)}")
    println()

    val (postoVencedor, combustivelVencedor) = if (custoWayne < custoStark) {
        Pair(wayneOil.nomePosto, opcaoWayne.lowercase())
    } else {
        Pair(starkPetrol.nomePosto, opcaoStark.lowercase())
    }

    println("$nomeUsuario, é mais barato abastecer com $combustivelVencedor no posto $postoVencedor.")
}
