import java.util.Vector

// 2.1. Leia dois números e mostre o maior deles.

fun main() {
    // utilizando vetor para poupar uma variável
    val entradas = Vector<Int>()

    print("Bem vindo ao Compara-números 9000!\n----------------------------------\n")
    for (i in 1..2) {
        entradas.add(readInt("Escreva o ${i}º número! "))
    }

    val numMaior: Int = entradas.max()
    val numMenor: Int = entradas.min()

    print("O numero maior é $numMaior, o menor é $numMenor")
}