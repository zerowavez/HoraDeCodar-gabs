// Exiba uma lista de planetas do sistema solar
// ("Mercúrio", "Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno" e "Plutão")
// para o usuário. Em seguida, peça ao usuário para digitar o nome de um planeta.
// Verifique se o planeta que o usuário informou está na lista e informe ao usuário.

fun main() {
    var continuar: Boolean = true
    var planetas =
        mutableListOf<String>("Mercúrio", "Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno", "Plutão")

    while (continuar) {
        println("Essa é a lista atual dos planetas!\n- ${planetas.joinToString("\n- ")}")

        var itemBusca: String = readString("Escolha um deles: ", 1)
        var itemBuscaFormatado = itemBusca.lowercase().replaceFirstChar { it.uppercase() }
        var itemSemAcentos = itemBuscaFormatado

        val indice = planetas.indexOfFirst { planeta -> planeta.removerAcentos().equals(itemSemAcentos, ignoreCase = true)}
        if (indice != -1) {
            println("$itemBuscaFormatado encontrado(a) na posição $indice da lista! ")
            var remover: Boolean = readUserOption("Deseja remover $itemBuscaFormatado da lista?", "S", "N")
            if (remover) {
                println("$itemBuscaFormatado foi removido! Continuando...")
                planetas.remove(itemBuscaFormatado)
                Thread.sleep(200)
            } else {
                println("$itemBuscaFormatado foi mantido! Continuando...")
                Thread.sleep(200)
            }
        } else {
            println("$itemBuscaFormatado não encontrado na lista...")
            var adicionar: Boolean = readUserOption("Deseja adicionar $itemBuscaFormatado na lista?", "S", "N")
            if (adicionar) {
                println("$itemBuscaFormatado adicionado com sucesso! Continuando...")
                planetas += itemBuscaFormatado
                Thread.sleep(200)
            } else {
                println("$itemBuscaFormatado descartado...")
                Thread.sleep(200)
            }
        }

        val quebra: Boolean = readUserOption("Quer continuar?", "S", "N")
        if (quebra) {
            println("Continuando...")
            Thread.sleep(200)
            continue
        } else {
            println("Até a próxima!")
            continuar = false
        }
    }
}
