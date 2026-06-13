package models;

import java.util.Scanner;

public class BibliotecaDigital {
    private Catalogo catalogo;
    private ListaDupla acervo;
    private GestorEmprestimos gestor;
    private Scanner scanner;

    public BibliotecaDigital() {
        this.catalogo = new Catalogo();
        this.acervo = new ListaDupla();
        this.gestor = new GestorEmprestimos();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 0;

        do {
            System.out.println("\n=====================================");
            System.out.println("   SISTEMA DA BIBLIOTECA DIGITAL");
            System.out.println("=====================================");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Buscar livro por ISBN");
            System.out.println("3. Listar acervo do início ao fim");
            System.out.println("4. Listar acervo do fim ao início");
            System.out.println("5. Solicitar empréstimo");
            System.out.println("6. Devolver livro");
            System.out.println("7. Ver fila de espera de um livro");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            switch (opcao) {
                case 1:
                    cadastrarLivroMenu();
                    break;
                case 2:
                    buscarLivroMenu();
                    break;
                case 3:
                    System.out.println("--- ACERVO COMPLETO (INÍCIO AO FIM) ---");
                    acervo.listarDoInicio();
                    break;
                case 4:
                    System.out.println("--- ACERVO COMPLETO (FIM AO INÍCIO) ---");
                    acervo.listarDoFim();
                    break;
                case 5:
                    solicitarEmprestimoMenu();
                    break;
                case 6:
                    devolverLivroMenu();
                    break;
                case 7:
                    verFilaMenu();
                    break;
                case 8:
                    System.out.println("Encerrando o sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 8);
    }


    private void cadastrarLivroMenu() {
        System.out.println("--- CADASTRAR NOVO LIVRO ---");
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        if (catalogo.existe(isbn)) {
            System.out.println("Erro: Já existe um livro cadastrado com este ISBN!");
            return;
        }

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        Livro novoLivro = new Livro(isbn, titulo, autor, ano);

        acervo.insereFim(novoLivro);
        catalogo.cadastrar(novoLivro);

        System.out.println("Sucesso: Livro '" + titulo + "' cadastrado no acervo e no catálogo!");
    }

    private void buscarLivroMenu() {
        System.out.print("Digite o ISBN para busca rápida: ");
        String isbn = scanner.nextLine();

        Livro encontrado = catalogo.buscar(isbn);

        if (encontrado != null) {
            System.out.println("Livro Encontrado: " + encontrado);
        } else {
            System.out.println("Nenhum livro encontrado com o ISBN: " + isbn);
        }
    }

    private void solicitarEmprestimoMenu() {
        System.out.println("--- SOLICITAR EMPRÉSTIMO ---");
        System.out.print("ISBN do Livro: ");
        String isbn = scanner.nextLine();

        if (!catalogo.existe(isbn)) {
            System.out.println("Erro: Livro não existe no catálogo.");
            return;
        }

        System.out.print("Matrícula do Usuário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();
        System.out.print("E-mail do Usuário: ");
        String email = scanner.nextLine();
        System.out.print("Nome do Usuário: ");
        String nome = scanner.nextLine();

        Usuario u = new Usuario(matricula, email, nome);

        gestor.solicitarEmprestimo(isbn, u, acervo);
    }

    private void devolverLivroMenu() {
        System.out.println("--- DEVOLVER LIVRO ---");
        System.out.print("ISBN do Livro: ");
        String isbn = scanner.nextLine();
        gestor.devolverLivro(isbn, acervo);
    }

    private void verFilaMenu() {
        System.out.print("ISBN do Livro para checar fila: ");
        String isbn = scanner.nextLine();

        if (!catalogo.existe(isbn)) {
            System.out.println("Erro: Livro não existe no catálogo.");
            return;
        }

        gestor.listarFilaDeEspera(isbn);
    }
}
