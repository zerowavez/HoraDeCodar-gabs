//Vamos criar uma lista de compras.

//Crie uma array de frutas, exiba-a ao usuário e, em seguida, peça ao usuário para digitar o nome de uma das frutas.
//Caso a fruta esteja no array, remova-a e exiba a mensagem "Fruta foi retirada da lista". Peça novamente para o usuário digitar o nome de uma fruta para ser removida.
//Sempre que o usuário procurar por uma fruta que não está no array exiba a mensagem "Fruta indisponível no nosso mercado".
//Quando o usuário digitar "PARE", exiba a lista de frutas restantes.
//Quando o array não possuir mais itens dentro de si, escreva "Lista de compras finalizada".

fun main() {
    var continuar = true
    val frutas = mutableListOf<String>("Maçã", "Banana", "Pitaia", "Graviola", "Carambola", "Lichia")

    println("Essa é sua lista de compras!\n- ${frutas.joinToString("\n- ")}")

    while (continuar) {
        var fruta = readString("Digite o nome de uma fruta: ", 1).lowercase().replaceFirstChar { it.uppercase() }

        if (fruta in frutas) {
            println("$fruta foi retirada da lista!")
            frutas.remove(fruta)
        } else {
            println("Fruta indisponível em nosso mercado!")
        }

        if (frutas.isEmpty()) {
            continuar = false
        }
    }

    println("Lista de compras finalizada!")
}
