fun autenticarUsuario(nome: String, modoTeste: Boolean): Boolean {
    // pra agilizar testes do sistema
    if (modoTeste) {
        return true
    }

    var tentativa: Int = 3

    println("Agora, insira sua senha para se autenticar: ")

    for (i in 1..3) {
        var senhaUsuario = readInt("")

        tentativa--

        if (senhaUsuario != 2678 && tentativa != 0) {
            println("Senha incorreta, tente novamente [${tentativa} tentativa(s) restante(s)]")
        } else if (tentativa == 0) {
            println("Você excedeu seu número de tentativas! Volte mais tarde...")
        } else {
            println("Bem-vindo ao Hotel $nomeHotel, $nome. É um imenso prazer ter você por aqui!")
            return true
        }
    }
    return false
}