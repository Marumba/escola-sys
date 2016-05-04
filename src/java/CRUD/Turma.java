package CRUD;

public class Turma {

    private int cod;
    private String nome;
    private String periodo;
    
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Turma [cod=" + cod + ", nome=" + nome
                + ", periodo=" + periodo + "]";
    }    
}