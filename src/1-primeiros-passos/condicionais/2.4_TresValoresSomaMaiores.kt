import java.util.Vector

// 2.4. Leia 3 valores diferentes e mostre a soma dos 2 maiores.

fun main() {
    val entradas = Vector<Int>()

    print("Bem vindo ao Soma-os-dois-maiores 9000!\n----------------------------------\n")

    for (i in 1..3) {
        entradas.add(readInt("Escreva o ${i}º número! "))
    }

    val entradasOrdenadas = entradas.sortedByDescending { it }

    val soma: Int = entradasOrdenadas[0] + entradasOrdenadas[1]

    print("----------------------------------\n")

    print("A soma entre os dois maiores números resultou em $soma!")
}