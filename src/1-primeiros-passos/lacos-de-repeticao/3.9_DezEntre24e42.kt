// Leia 10 valores e informe quantos estão no intervalo
// de 24 a 42 (inclusive) e quantos estão fora.

fun main() {
    var valores = intArrayOf()
    var entre24e42 = intArrayOf()

    print("Bem vindo ao Calcula-media-aritmética 9000!\n----------------------------------\n")
    for (i in 1..10) {
        val num: Int = readInt("Escreva o ${i}º número! ")
        valores += num
        if (num in 25..<42) {
            entre24e42 += num
        }
    }

    println("Os números entre 24 e 42 são: ${entre24e42.joinToString(", ")}")

    println("E os demais são: ${valores.joinToString(", ")}")

}