// 2.5. Leia 6 valores, exiba todos e calcule a média aritmética.

fun main() {
    var notas = DoubleArray(6)

    print("Bem vindo ao Calcula-media-aritmética 9000!\n----------------------------------\n")
    for (i in 1..6) {
        notas += (readDouble("Escreva o ${i}º número! ", 0.0, 10.0))
    }
    print("A sua média é de ${calcularMedia(notas)}")
}