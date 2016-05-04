
package CRUD.model;

import CRUD.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurmaDao {

    private Connection connection;

    public TurmaDao() {
        connection = Conexao.Conectar();
    }

    public void add(Turma turma) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into turmas(periodo,nome) values (?, ?)");
            preparedStatement.setString(1, turma.getPeriodo());
            preparedStatement.setString(2, turma.getNome());           
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int turmaCod) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from turmas where cod=?");
            preparedStatement.setInt(1, turmaCod);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Turma turma) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update turmas set nome=?, periodo=?" +
                            "where cod=?");
            preparedStatement.setString(1, turma.getNome());
            preparedStatement.setString(2, turma.getPeriodo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Turma> getAll() {
        List<Turma> turmas = new ArrayList<Turma>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from turmas");
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setCod(rs.getInt("cod"));
                turma.setNome(rs.getString("nome"));
                turma.setPeriodo(rs.getString("periodo"));
                turmas.add(turma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return turmas;
    }

    public Turma getById(int turmaId) {
        Turma turma = new Turma();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from turmas where cod=?");
            preparedStatement.setInt(1, turmaId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                turma.setCod(rs.getInt("cod"));
                turma.setNome(rs.getString("nome"));
                turma.setPeriodo(rs.getString("periodo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return turma;
    }
    
    public int countRows(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from turmas");
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