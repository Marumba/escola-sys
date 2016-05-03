package CRUD;

import java.util.Date;

public class Usuario {

    private int userid;
    private String funcao;
    private String nome;
    private Date entrada;
    private String email;
    private String senha;
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }
    public Date getEntrada() {
        return entrada;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Usuário [id=" + userid + ", nome=" + nome
                + ", data de entrada=" + entrada + ", email="
                + email + "]";
    }    
}