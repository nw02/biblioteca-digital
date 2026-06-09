package models;

public class ListaDupla {
    private NoDuplo primeiro;
    private NoDuplo ultimo;

    public void insereInicio(Livro livro){
        NoDuplo novo = new NoDuplo(livro);
        if(estaVazia()){
            ultimo = novo;
        }else{
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public void insereFim(Livro livro){
        NoDuplo novo = new NoDuplo(livro);
        ultimo.setProximo(novo);
        novo.setAnterior(ultimo);
        ultimo = novo;
    }

    public Livro removePrimeiro(){
        if(estaVazia()) return null;
        Livro copia = primeiro.getLivro();
        primeiro = (NoDuplo)primeiro.getProximo();
        if(primeiro == null)
            ultimo = null;
        else
            primeiro.setAnterior(null);
        return copia;
    }

    public Livro removeUltimo(){
        if(estaVazia()) return null;
        Livro copia = ultimo.getLivro();
        ultimo = ultimo.getAnterior();
        if(ultimo == null)
            primeiro = null;
        else
            ultimo.setProximo(null);
        return copia;
    }

    private boolean estaVazia(){
        return primeiro == null;
    }
}
