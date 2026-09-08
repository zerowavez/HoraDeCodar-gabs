// Leia 2 notas de um aluno, calcule a média final e considere aprovação com nota 9,5.
// Em seguida, pergunte: Calcular a média de outro aluno? (S/N). Se a resposta
// for S, repita; caso contrário, encerre e mostre a quantidade de alunos aprovados.

fun main() {
    print("Bem vindo ao Calcula-media-aritmética Ultimate Edition!\n----------------------------------\n")
    while (true) {

        var nota1 = readDouble("Escreva a primeira nota do aluno: ", 0.0, 10.0)
        var nota2 = readDouble("Escreva a primeira nota do aluno: ", 0.0, 10.0)
        var notas: DoubleArray = doubleArrayOf(nota1, nota2)

        if (calcularMedia(notas) < 9.5) {
            println("O aluno foi reprovado...")
        } else {
            println("O aluno foi aprovado!")
        }

        val selecao: String = readString("Calcular media de outro aluno?? ")
        if (selecao[0].uppercase() == "N" ) {
            println("Volte novamente!")
            break
        } else if (selecao[0].uppercase() == "S" ) {
            continue
        } else {
            println("Opção inválida, tente novamente...")
        }
    }
}