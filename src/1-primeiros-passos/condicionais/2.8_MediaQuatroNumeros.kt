// 2.8. Leia 4 números, aceitando apenas valores maiores que 0 e
// menores que 10. Calcule a média

fun main() {
    var notas = DoubleArray(6)

    print("Bem vindo ao Calcula-media-aritmética 9001!\n----------------------------------\n")
    for (i in 1..4) {
        notas += (readDouble("Escreva a ${i}º nota! ", 0.0, 10.0))
    }
    print("A sua média é de ${calcularMedia(notas)}")
}