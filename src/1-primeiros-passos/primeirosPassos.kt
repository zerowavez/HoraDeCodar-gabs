/**
 *  1.1. Crie uma variável chamada nome_do_carro, atribua o valor "Fusca" e exiba esse valor na tela.

1.2. Peça ao usuário que informe o nome e exiba a mensagem: Olá, NomeDoUsuario.

1.3. Peça ao usuário nome e idade e exiba: Olá, NomeDoUsuario, sua idade é idade.
 */

fun main() {
    val nomeDoCarro = "Fusca"

    val nomeDoUsuario: String = readString("Digite seu nome: ", 1, 10)

    val idade: Int = readInt("E qual é sua idade? ", 1, 999)

    println("Seu nome é $nomeDoUsuario, sua idade é $idade e seu carro é um $nomeDoCarro!")
}