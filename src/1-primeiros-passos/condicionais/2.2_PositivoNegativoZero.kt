// 2.2. Leia um valor e diga se ele é positivo, negativo ou zero.

fun main() {
    val entrada =  readInt("Digite um número! ")

    if (entrada > 0) {
        print("O número $entrada é positivo!")
    } else if (entrada < 0) {
        print("O número $entrada é negativo!")
    } else {
        print("O número $entrada é igual a zero!")
    }
}