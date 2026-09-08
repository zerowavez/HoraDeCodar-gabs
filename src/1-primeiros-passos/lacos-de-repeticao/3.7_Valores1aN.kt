// Leia um valor N (N > 0) e imprima todos os inteiros de 1 até N

fun main() {
    val num1: Int = readInt("Escreva o número de início da contagem: ")
    val num2: Int = readInt("Agora o final da contagem, deve ser maior que o início: ", num1)

    for (i in num1..num2) {
        println(i)
        Thread.sleep(200)
    }
}