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
        primeiro = primeiro.getProximo();
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

    public Livro buscarPorIsbn(String isbn){
        if(estaVazia()) return null;
        NoDuplo runner = primeiro;
        while(!runner.getLivro().getIsbn().equals(isbn)){
            if(runner.getProximo() == null) return null;
            runner = runner.getProximo();
        }
        return runner.getLivro();
    }

    public void listarDoInicio(){
        if (estaVazia()){ System.out.println("[]"); return;}
        NoDuplo runner = primeiro;
        while (runner != null){
            System.out.println(runner);
            runner = runner.getProximo();
        }
    }

    public void listarDoFim(){
        if (estaVazia()){ System.out.println("[]"); return;}
        NoDuplo runner = ultimo;
        while (runner != null){
            System.out.println(runner);
            runner = runner.getAnterior();
        }
    }

    public int tamanho(){
        if (estaVazia()) return 0;
        int i=0;
        NoDuplo runner = primeiro;
        while (runner != null){
            i +=1;
            runner = runner.getProximo();
        }
        return i;
    }

    private boolean estaVazia(){
        return primeiro == null;
    }
}
