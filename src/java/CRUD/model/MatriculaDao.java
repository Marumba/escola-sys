
package CRUD.model;

import CRUD.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatriculaDao {

    private Connection connection;

    public MatriculaDao() {
        connection = Conexao.Conectar();
    }

    public void add(Matricula matricula) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into matriculas(curso,turma,professor,aluno) values (?, ?,?,?)");
            preparedStatement.setInt(1, matricula.getCurso());
            preparedStatement.setInt(2, matricula.getTurma());           
            preparedStatement.setInt(3, matricula.getProfessor());           
            preparedStatement.setInt(4, matricula.getAluno());           
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int matriculaCod) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from matriculas where cod=?");
            preparedStatement.setInt(1, matriculaCod);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Matricula matricula) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update matriculas set turma=?, curso=?, professor=?, aluno=? " +
                            "where cod=?");
            preparedStatement.setInt(1, matricula.getTurma());           
            preparedStatement.setInt(2, matricula.getCurso());
            preparedStatement.setInt(3, matricula.getProfessor());           
            preparedStatement.setInt(4, matricula.getAluno());    
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Matricula> getAll() {
        List<Matricula> matriculas = new ArrayList<Matricula>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from matriculas");
            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setCod(rs.getInt("cod"));
                matricula.setTurma(rs.getInt("turma"));
                matricula.setCurso(rs.getInt("curso"));
                matricula.setProfessor(rs.getInt("professor"));
                matricula.setAluno(rs.getInt("aluno"));
                matriculas.add(matricula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matriculas;
    }

    public Matricula getById(int matriculaId) {
        Matricula matricula = new Matricula();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from matriculas where cod=?");
            preparedStatement.setInt(1, matriculaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                matricula.setCod(rs.getInt("cod"));
                matricula.setTurma(rs.getInt("turma"));
                matricula.setCurso(rs.getInt("curso"));
                matricula.setProfessor(rs.getInt("professor"));
                matricula.setAluno(rs.getInt("aluno"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matricula;
    }
    
    public int countRows(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from matriculas");
            while (rs.next()) {
                return rs.getInt(1);   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    } 

    public int altQuery(String query){

       try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}