package CRUD;

public class Aluno {

    private int ra;
    private String nome;
    private String rg;
    private long cpf;
    
    public int getRa() {
        return ra;
    }
    public void setRa(int ra) {
        this.ra = ra;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    @Override
    public String toString() {
        return "Usuário [ra=" + ra + ", nome=" + nome
                + ", rg=" + rg + ", cpf="
                + cpf + "]";
    }    
}