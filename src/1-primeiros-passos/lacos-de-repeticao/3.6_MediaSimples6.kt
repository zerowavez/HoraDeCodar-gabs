// Leia 6 notas válidas (de 0 a 10), calcule e exiba a média simples.

fun main() {
    var notas = DoubleArray(6)

    print("Bem vindo ao Calcula-media-aritmética 9000 v2!\n----------------------------------\n")
    for (i in 1..6) {
        notas += (readDouble("Escreva o ${i}º número! ", 0.0, 10.0))
    }
    print("A sua média é de ${calcularMedia(notas)}")
}