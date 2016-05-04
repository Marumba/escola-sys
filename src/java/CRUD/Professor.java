package CRUD;

public class Professor {

    private int rp;
    private String nome;
    private String rg;
    private long cpf;
    
    public int getRp() {
        return rp;
    }
    public void setRp(int rp) {
        this.rp = rp;
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
        return "Professor [rp=" + rp + ", nome=" + nome
                + ", rg=" + rg + ", cpf="
                + cpf + "]";
    }    
}