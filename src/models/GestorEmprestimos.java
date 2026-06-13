package models;

public class GestorEmprestimos {
    private NossoHash<String, Fila<Usuario>> filaEmprestimo;

    public GestorEmprestimos() {
        filaEmprestimo = new NossoHash<>();
    }

    public void solicitarEmprestimo (String isbn, Usuario u, ListaDupla acervo){
        Livro livro = acervo.buscarPorIsbn(isbn);
        if(livro == null){
            System.out.println("Livro não encontrado");
            return;
        }
        if(livro.isDisponivel()){
            livro.setDisponivel(false);
            System.out.println("Empréstimo registrado");
            return;
        }
        System.out.println("Livro indisponivel, "+u.getNome()+" foi para a fila de espera.");

        Fila<Usuario> filaExistente= filaEmprestimo.get(isbn);
        if(filaExistente == null){
            filaExistente = new Fila<Usuario>();
            filaEmprestimo.put(isbn, filaExistente);
        }
        filaExistente.enfileira(u);
    }

    public void devolverLivro (String isbn, ListaDupla acervo){
        Livro livro = acervo.buscarPorIsbn(isbn);

        if(livro == null){
            System.out.println("Livro não encontrado");
            return;
        }

        Fila<Usuario> fila= filaEmprestimo.get(isbn);
        if(fila == null || fila.tamanho() == 0){
            livro.setDisponivel(true);
            System.out.println("Livro devolvido, disponivel para novos emprestimos");
        }else{
            Usuario proximoUsuario = fila.desenfileira();
            System.out.println("Livro devolvido e transferido para "+proximoUsuario.getNome());
        }
    }

    public void listarFilaDeEspera(String isbn){
        Fila<Usuario> fila = filaEmprestimo.get(isbn);
        if(fila == null || fila.tamanho() == 0){
            System.out.println("Não tem ninguém aguardando");
        } else{
            System.out.println(fila);
        }
    }
}
