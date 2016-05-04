package CRUD;

public class Curso {

    private int cod;
    private String nome;
    private String area;
    
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
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Curso [cod=" + cod + ", nome=" + nome
                + ", area=" + area + "]";
    }    
}