package models;

public class TesteListaDupla {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Testes da Lista Duplamente Encadeada ---");

        // Inicializando a lista
        ListaDupla lista = new ListaDupla();

        // Criando instâncias de livros
        Livro livro1 = new Livro("1111", "Java Como Programar", "Deitel", 2015);
        Livro livro2 = new Livro("2222", "Estruturas de Dados", "Goodrich", 2013);
        Livro livro3 = new Livro("3333", "Clean Code", "Robert C. Martin", 2008);

        //Teste inserções no início e no fim 
        System.out.println("\n>> Inserindo livros no acervo...");
        lista.insereInicio(livro1);
        lista.insereFim(livro2);
        lista.insereFim(livro3);

        //Verifica o tamanho 
        System.out.println("Tamanho atual da lista: " + lista.tamanho());

        //Testa a listagem do início ao fim
        System.out.println("\n>> Listando do Início ao Fim:");
        lista.listarDoInicio();

        //Testa a listagem do fim ao início
        System.out.println("\n>> Listando do Fim ao Início (Navegação reversa):");
        lista.listarDoFim();

        //Testando a busca por ISBN existente
        System.out.println("\n>> Buscando livro por ISBN (222-22):");
        Livro encontrado = lista.buscarPorIsbn("222-22");
        if (encontrado != null) {
            System.out.println("Sucesso! Livro encontrado: " + encontrado);
        } else {
            System.out.println("Falha: Livro não encontrado.");
        }

        //Testa a busca por ISBN inexistente 
        System.out.println("\n>> Buscando livro inexistente (9999):");
        Livro naoEncontrado = lista.buscarPorIsbn("9999");
        if (naoEncontrado == null) {
            System.out.println("Sucesso! O sistema retornou null como esperado.");
        } else {
            System.out.println("Falha: O sistema encontrou um livro que não deveria existir.");
        }

        //Testa as remoções 
        System.out.println("\n>> Removendo o primeiro livro da lista...");
        Livro removidoPrimeiro = lista.removePrimeiro();
        System.out.println("Removido: " + (removidoPrimeiro != null ? removidoPrimeiro.toString() : "Nenhum (lista vazia)"));

        System.out.println("\n>> Removendo o último livro da lista...");
        Livro removidoUltimo = lista.removeUltimo();
        System.out.println("Removido: " + (removidoUltimo != null ? removidoUltimo.toString() : "Nenhum (lista vazia)"));

        // 8. Validando o estado final da lista
        System.out.println("\n>> Status final da lista após remoções:");
        lista.listarDoInicio();
        System.out.println("Tamanho final da lista: " + lista.tamanho());
    }
}