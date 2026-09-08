import java.time.LocalDate

//2.9. Leia o ano de nascimento e informe se a pessoa pode votar no ano atual
// (sem considerar o mês).

fun main() {
    val hoje = LocalDate.now()
    val anoAtual = hoje.year.toInt()

    print("Bem vindo ao Descobre-se-você-pode-votar 9000!\n----------------------------------\n")

    val anoNascimento: Int = readInt("Em que ano você nasceu? ", 1)
    val idade: Int = anoAtual - anoNascimento

    var anosAteVotar: Int = 0

    if (idade <= 16) {
        for (i in idade..15) {
            anosAteVotar++
        }
    }

    if (idade >= 16) {
        print("Tudo certo! Você já pode votar!")
    } else {
        print("Ainda não é hora de votar, espere mais $anosAteVotar anos...")
    }
}
