package models;

public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPub;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor, int anoPub) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPub = anoPub;
        disponivel = true;
    }

    @Override
    public String toString(){
        String dispo;
        if(disponivel) dispo = "DISPONIVEL";
        else dispo = "INDISPONIVEL";
        return "["+isbn+"] "+titulo+" - ("+anoPub+") ["+dispo+"]";
    }

    public boolean equals(String isbn){
        if(isbn.equals(this.isbn)){
            return true;
        }else{
            return false;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPub() {
        return anoPub;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
