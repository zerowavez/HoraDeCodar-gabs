// Imprima os 10 primeiros números inteiros maiores que 100.

fun main() {
    var inicio: Int = 100

    for (i in 1..11) {
        println(inicio++)
        Thread.sleep(200)
    }
}