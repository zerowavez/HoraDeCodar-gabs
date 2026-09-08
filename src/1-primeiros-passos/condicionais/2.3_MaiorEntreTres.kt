import java.util.Vector

// 2.3. Leia 3 valores diferentes e mostre o maior.

fun main() {
    val entradas = Vector<Int>()

    print("Bem vindo ao Compara-números 9001!\n----------------------------------\n")
    for (i in 1..3) {
        entradas.add(readInt("Escreva o ${i}º número! "))
    }

    val numMaior = entradas.max()
    val numMenor = entradas.min()

    print("----------------------------------\n")
    print("$numMaior é o maior número! $numMenor é o menor!")
}