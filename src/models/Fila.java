package models;

public class Fila<T> {
    private No<T> primeiro;
    private No<T> ultimo;

    public void enfileira (T info){
        No<T> novo= new No<>(info);
        if (filaVazia()){
            primeiro = novo;
            ultimo = novo;
        } else{
            ultimo.setProximo(novo);
            ultimo = novo;
        }
    }

    @Override
    public String toString(){
        if(filaVazia()) return "Não tem nada";
        String str = "";
        No<T> runner = primeiro;
        while(runner != null){
            if(runner.getProximo() != null){
                str += "["+runner.getInfo()+"] ->";
            }else{
                str += "["+runner.getInfo()+"] -> //";
            }
            runner = runner.getProximo();
        }
        return str;
    }

    public T desenfileira (){
        if(filaVazia()) throw new FilaVaziaException("A fila está vazia, não há o que desenfileirar");
        No<T> copia = primeiro;
        if(primeiro.getProximo() == null){
            primeiro = null;
            ultimo = null;
        }else{
            primeiro = primeiro.getProximo();
        }
        return copia.getInfo();
    }

    public T primeiro (){
        if (filaVazia()) return null;
        return primeiro.getInfo();
    }

    public int tamanho(){
        if (filaVazia()) return 0;
        No<T> runner = primeiro;
        int tamanho = 0;
        while(runner != null){
            tamanho++;
            runner = runner.getProximo();
        }
        return tamanho;
    }

    private boolean filaVazia(){
        return primeiro == null;
    }
}
