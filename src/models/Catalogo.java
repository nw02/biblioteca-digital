package models;

public class Catalogo {
    private NossoHash<String, Livro> hashLivros;

    public Catalogo() {
        this.hashLivros = new NossoHash<>();
    }

    public void cadastrar(Livro livro) {
        hashLivros.put(livro.getIsbn(), livro);
    }

    public Livro buscar(String isbn) {
        return hashLivros.get(isbn);
    }

    public boolean existe(String isbn) {
        return hashLivros.containsKey(isbn);
    }

    public void exibirCatalogo() {
        hashLivros.exibeMap();
    }
}
