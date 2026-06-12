package models;

public class NoDuplo{
    private Livro livro;
    private NoDuplo proximo;
    private NoDuplo anterior;

    public NoDuplo (Livro livro){
        this.livro = livro;
    }

    @Override
    public String toString(){
        return livro.toString();
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public Livro getLivro() {
        return livro;
    }

    public NoDuplo getProximo() {
        return proximo;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }
}
