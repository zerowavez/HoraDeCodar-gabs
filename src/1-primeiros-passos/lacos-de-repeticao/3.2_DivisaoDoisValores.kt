// 3.2. Leia dois valores. Enquanto o segundo valor for menor ou igual a zero,
// peça novamente esse mesmo valor. Ao final, mostre a divisão do primeiro pelo segundo.

fun main() {
    val num1: Int = readInt("Escreva o primeiro número: ")
    val num2: Int = readInt("Escreva o segundo número: ", 1)

    print("O resultado da divisão do número $num1 pelo número $num2 é ${num1 / num2}")
}
