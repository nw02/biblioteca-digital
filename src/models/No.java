package models;

public class No {
    private Livro livro;
    private No proximo;
    public No(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString(){
        return livro.toString();
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public Livro getLivro() {
        return livro;
    }

    public No getProximo() {
        return proximo;
    }
}
