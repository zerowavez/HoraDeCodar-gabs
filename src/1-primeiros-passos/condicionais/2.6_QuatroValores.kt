import kotlin.collections.plus

// 2.6. Leia 4 valores diferentes e informe apenas o primeiro, o último e o maior deles.

fun main() {
    var valores = intArrayOf()

    print("Bem vindo ao Informa-números Mágico!!\n----------------------------------\n")
    for (i in 1..4) {
        valores += (readInt("Escreva o ${i}º número! "))
    }

    print("$valores\n")

    print("""
        O primeiro número é ${valores.first()}
        O último número é ${valores.last()}
        O maior número é ${valores.maxOf { it }}
    """.trimIndent())
}