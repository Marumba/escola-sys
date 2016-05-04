
package CRUD.model;

import CRUD.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CursoDao {

    private Connection connection;

    public CursoDao() {
        connection = Conexao.Conectar();
    }

    public void add(Curso curso) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into cursos(area,nome) values (?, ?)");
            preparedStatement.setString(1, curso.getArea());
            preparedStatement.setString(2, curso.getNome());           
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int cursoCod) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cursos where cod=?");
            preparedStatement.setInt(1, cursoCod);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Curso curso) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update cursos set nome=?, area=?" +
                            "where cod=?");
            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setString(2, curso.getArea());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> getAll() {
        List<Curso> cursos = new ArrayList<Curso>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cursos");
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setCod(rs.getInt("cod"));
                curso.setNome(rs.getString("nome"));
                curso.setArea(rs.getString("area"));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public Curso getById(int cursoId) {
        Curso curso = new Curso();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cursos where cod=?");
            preparedStatement.setInt(1, cursoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                curso.setCod(rs.getInt("cod"));
                curso.setNome(rs.getString("nome"));
                curso.setArea(rs.getString("area"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return curso;
    }
    
    public int countRows(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from cursos");
            while (rs.next()) {
                return rs.getInt(1);   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}