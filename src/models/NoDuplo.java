package models;

public class NoDuplo extends No{
    private NoDuplo anterior;

    public NoDuplo (Livro livro){
        super(livro);
    }

    public NoDuplo getAnterior() {
        return anterior;
    }
    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }
}
