import kotlin.collections.plus

// 2.7. Leia 6 números. Some apenas os valores menores que 72.
// Exiba a soma e todos os valores informados.

fun main() {
    var valores = intArrayOf()
    var menosQue72 = intArrayOf()

    print("Bem vindo ao Soma-apenas-menores-que-72 7200!\n----------------------------------\n")
    for (i in 1..6) {
        val num: Int = readInt("Escreva o ${i}º número! ")
        valores += num
        if (num < 72) {
            menosQue72 += num
        }
    }

    println("Todos os valores inseridos foram: ${valores.joinToString(", ")}")

    println("A soma de todos os números menores que 72 é ${menosQue72.sum()}")

}