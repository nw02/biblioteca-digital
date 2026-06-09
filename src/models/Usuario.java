package models;

public class Usuario {
    private int matricula;
    private String nome;
    private String email;

    public Usuario(int matricula, String email, String nome) {
        this.matricula = matricula;
        this.email = email;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "["+matricula+"] "+nome+" email: "+email;
    }

    public boolean equals(int matricula){
        if(matricula == this.matricula){
            return true;
        }else{
            return false;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
