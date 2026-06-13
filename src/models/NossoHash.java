package models;

public class NossoHash<K, V> {
    Entrada<K, V> [] tabela;
    int capacidade;

    @SuppressWarnings("unchecked")
    public NossoHash() {
        tabela = new Entrada[16];
        capacidade = 16;
    }

    private int hash (K key) {
        return Math.abs(key.hashCode()) % capacidade;
    }

    public void put (K key, V value){
        int posicao = hash(key);
        if(tabela[posicao] == null){
            tabela[posicao] = new Entrada<>(key, value);
            return;
        }
        Entrada<K,V> runner = tabela[posicao];
        while(runner != null){
            if(runner.key.equals(key)){
                runner.value = value;
                return;
            }

            if(runner.proximo == null){
                break;
            }
            runner = runner.proximo;
        }
        runner.proximo = new Entrada<>(key, value);
    }

    public V get (K key){
        int posicao = hash(key);
        Entrada<K, V> atual =tabela[posicao];
        while(atual != null){
            if(key.equals(atual.key)) return atual.value;
            atual = atual.proximo;
        }
        return null;
    }

    public boolean containsKey(K key){
        int posicao = hash(key);
        Entrada<K, V> atual =tabela[posicao];
        while(atual != null){
            if(key.equals(atual.key)) return true;
            atual = atual.proximo;
        }
        return false;
    }

    public boolean containsValue(V value){
        for(int i=0; i<capacidade;i++){
            Entrada<K, V> atual =tabela[i];
            while(atual != null){
                if(value.equals(atual.value)) return true;
                atual = atual.proximo;
            }
        }
        return false;
    }

    public void exibeMap(){
        for(int i=0; i<capacidade;i++){
            Entrada<K, V> atual =tabela[i];
            while(atual != null){
                System.out.println("chave: "+atual.key+", valor:"+atual.value);
                atual = atual.proximo;
            }
        }
    }
}
