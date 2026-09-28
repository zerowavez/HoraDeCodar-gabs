import kotlin.system.exitProcess

class bichinhoVirtual(val nome: String) {

    var idade = 1
    var nivelDeFome = 50
    var nivelFelicidade = 50
    var nivelCansaco = 50

    fun alimentar() {
        nivelDeFome -= 10
        println("$nome foi alimentado. O nível de fome diminuiu.")
    }

    fun brincar() {
        nivelFelicidade += 10
        nivelCansaco += 10
        println("$nome está brincando e se sentindo mais feliz.")
    }

    fun descansar() {
        nivelCansaco -= 10
        println("$nome descansou. O nível de cansaço diminuiu.")
    }

    fun verificarStatus() {
        println("Status atual de $nome:")
        println("Idade atual: $idade")
        println("Nível de fome: $nivelDeFome")
        println("Nível de felicidade: $nivelFelicidade")
        println("Nível de cansaço: $nivelCansaco")
    }

    fun passarTempo() {
        idade += 1
        nivelDeFome += 3
        nivelFelicidade -= 3
        nivelCansaco += 1
        println("$nome envelheceu 1 ano e está ficando mais faminto com o passar do tempo.")
    }

    fun perda(razao: String) {
        println("$nome foi embora para às colinas pelo seguinte motivo:\n '$razao'")
        exitProcess(0)
    }
}