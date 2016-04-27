package CRUD;

import java.util.Date;

public class Usuario {

    private int id;
    private String funcao;
    private String nome;
    private Date entrada;
    private String email;
    private String senha;
    public int getUserid() {
        return id;
    }
    public void setUserid(int id) {
        this.id = id;
    }
    public String getFunction() {
        return funcao;
    }
    public void setFunction(String funcao) {
        this.funcao = funcao;
    }
    public String getName() {
        return nome;
    }
    public void setName(String nome) {
        this.nome = nome;
    }
    public Date getEnterDate() {
        return entrada;
    }
    public String getPass() {
        return senha;
    }
    public void setEnterDate(Date entrada) {
        this.entrada = entrada;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Usuário [id=" + id + ", nome=" + nome
                + ", data de entrada=" + entrada + ", email="
                + email + "]";
    }    
}