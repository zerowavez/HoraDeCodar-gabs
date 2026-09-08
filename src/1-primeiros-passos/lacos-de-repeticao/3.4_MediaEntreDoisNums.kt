// Leia dois inteiros (sendo o primeiro menor que o segundo)
// e calcule a média desses números e de todos os inteiros entre eles.

fun main() {
    val num1: Int = readInt("Escreva o primeiro número para o cálculo da média: ")
    val num2: Int = readInt("Agora o segundo, deve ser maior que o primeiro: ", num1)
    var valores: DoubleArray = doubleArrayOf()

    for (i in num1..num2) {
        valores += i.toDouble()
    }

    print("A média dos números entre 15 e 100 (inclusive) é de ${calcularMedia(valores)}")
}