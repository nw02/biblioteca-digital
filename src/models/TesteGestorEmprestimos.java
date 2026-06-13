package models;

public class TesteGestorEmprestimos {
    public static void main(String[] args) {
        GestorEmprestimos gestor = new GestorEmprestimos();
        ListaDupla acervo = new ListaDupla();

        //Criando o livro para o teste
        Livro livro = new Livro("1234", "Estruturas de Dados", "Goodrich", 2013);

        //Criando alguns usuários para o teste
        Usuario u1 = new Usuario(1001, "joao@email.com", "João Silva");
        Usuario u2 = new Usuario(1002, "maria@email.com", "Maria Souza");
        Usuario u3 = new Usuario(1003, "pedro@email.com", "Pedro Santos");

        //Empréstimo de um livro disponível
        System.out.println("João tenta pegar o livro disponível ===");
        acervo.insereInicio(livro);
        gestor.solicitarEmprestimo(livro.getIsbn(), u1, acervo);
        System.out.println("Estado atual do livro: " + livro + "\n");

        //Tentativa de emprestar o mesmo livro (gerando fila)
        System.out.println("Maria e Pedro tentam pegar o mesmo livro ===");
        gestor.solicitarEmprestimo(livro.getIsbn(), u2, acervo);
        gestor.solicitarEmprestimo(livro.getIsbn(), u3, acervo);

        gestor.listarFilaDeEspera("1234");
        System.out.println();

        //Devolução com atendimento automático do próximo da fila
        System.out.println("João devolve o livro");
        //Como Maria é a primeira da fila, o livro deve ir direto para ela
        gestor.devolverLivro(livro.getIsbn(), acervo);

        System.out.println("\nComo ficou a fila de espera agora?");
        gestor.listarFilaDeEspera("1234");
        System.out.println("Estado atual do livro: " + livro + "\n");

        System.out.println("Maria devolve o livro ===");
        gestor.devolverLivro(livro.getIsbn(), acervo);

        gestor.listarFilaDeEspera("1234");
        System.out.println();

        //Segunda devolução (com fila vazia)
        System.out.println("Pedro finalmente devolve o livro ===");
        //Como não tem mais ninguém na fila, o livro deve voltar a ficar DISPONÍVEL
        gestor.devolverLivro(livro.getIsbn(), acervo);
        System.out.println("Estado do livro: " + livro + "\n");
    }
}
