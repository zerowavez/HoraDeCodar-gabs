// Crie um programa onde o usuário possa cadastrar estudantes sem limites, e, em seguida,
// Se o usuário digitar "PARE" o programa deve exibir a quantidade de estudantes cadastrados
// e a lista com cada um deles.

fun main() {
    var continuar = true
    var estudantes = mutableListOf<String>()

    println("Bem vindo ao Cadastra-estudantes 9000!\nVocê pode sair a qualquer momento escrevendo 'PARE'\n--------------------")

    while (continuar) {
        var estudante = readString("Vamos registrar um estudante? ", 1)
        if (estudante != "PARE") {
            println("$estudante adicionado, continuando...")
            Thread.sleep(200)
            estudantes.add(estudante)
        } else {
            println("Encerrando...\n--------------------")
            Thread.sleep(200)
            continuar = false
        }
    }
    println("Programa encerrado, ${estudantes.size} estudantes foram registrados, são eles:")
    println(estudantes.joinToString("\n"))
}
