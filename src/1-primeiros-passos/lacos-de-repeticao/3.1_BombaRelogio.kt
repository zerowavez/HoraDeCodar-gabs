// 3.1. Crie uma bomba-relógio com contagem regressiva de 30 até 0 e
// ao final, escreva EXPLOSÃO.

fun main() {
    var ctdn: Int = 30
    for (i in 0..30) {
        println(ctdn--)
        Thread.sleep(200)
    }
    println("boom chakalaka")
}
