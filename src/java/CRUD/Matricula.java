package CRUD;

public class Matricula {

    private int cod;
    private int curso;
    private int turma;
    private int professor;
    private int aluno;
    
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public int getCurso() {
        return curso;
    }
    public void setCurso(int curso) {
        this.curso = curso;
    }
    public int getTurma() {
        return turma;
    }
    public void setTurma(int turma) {
        this.turma = turma;
    }    
    public int getProfessor() {
        return professor;
    }
    public void setProfessor(int professor) {
        this.professor = professor;
    }
    public int getAluno() {
        return aluno;
    }
    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Turma [cod=" + cod + ", curso=" + curso
                + ", turma=" + turma + ", professor="+ professor 
                +", aluno="+ aluno +"]";
    }    
}