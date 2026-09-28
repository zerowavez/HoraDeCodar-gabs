fun main() {

    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!")
    val nomePet = readString("Digite o nome do seu animal de estimação:", 1).replaceFirstChar { it.uppercase() }
    val pet = bichinhoVirtual(nomePet)

    while (true) {
        println("\nEscolha uma ação:")
        println("1. Alimentar $nomePet")
        println("2. Brincar com $nomePet")
        println("3. Deixar $nomePet descansar")
        println("4. Verificar o status de $nomePet")
        println("4. Sair")

        val escolha = readln().toInt() ?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.descansar()
            4 -> pet.verificarStatus()
            5 -> {
                println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!")
                return
            }
            else -> println("Escolha inválida. Tente novamente.")
        }

        pet.passarTempo() // Simula o tempo que passa após cada ação
        if (pet.nivelDeFome > 100) {
            pet.perda("Fiquei com muita fome então fui às colinas comer morangos silvestres. Adeus!")
        } else if (pet.nivelCansaco > 100) {
            pet.perda("Estava muito cansado então fui até às colinas deitar em baixo de uma árvore. Adeus!")
        } else if (pet.nivelFelicidade < 0) {
            pet.perda("Estava muito infeliz, então fui até às colinas ver meus amigos pássaros cantarem. Adeus!")
        }
    }
}