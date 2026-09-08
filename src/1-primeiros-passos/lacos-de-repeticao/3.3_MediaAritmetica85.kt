// Calcule e exiba a média aritmética dos números inteiros de 15 a 100 (inclusive).

fun main() {
    var valores: DoubleArray = doubleArrayOf()

    for (i in 15..100) {
        valores += i.toDouble()
    }

    print("A média dos números entre 15 e 100 (inclusive) é de ${calcularMedia(valores)}")
}