
package CRUD.model;

import CRUD.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDao {

    private Connection connection;

    public ProfessorDao() {
        connection = Conexao.Conectar();
    }

    public void add(Professor professor) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into professores(rg,nome,cpf) values (?, ?, ?)");
            preparedStatement.setString(1, professor.getRg());
            preparedStatement.setString(2, professor.getNome());           
            preparedStatement.setLong(3, professor.getCpf());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int professorRa) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from professores where rp=?");
            preparedStatement.setInt(1, professorRa);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Professor professor) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update professores set nome=?, rg=?, cpf=?" +
                            "where rp=?");
            preparedStatement.setString(1, professor.getNome());
            preparedStatement.setString(2, professor.getRg());
            preparedStatement.setLong(3, professor.getCpf());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Professor> getAll() {
        List<Professor> professores = new ArrayList<Professor>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from professores");
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setRp(rs.getInt("rp"));
                professor.setNome(rs.getString("nome"));
                professor.setRg(rs.getString("rg"));
                professor.setCpf(rs.getLong("cpf"));
                professores.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professores;
    }

    public Professor getById(int professorId) {
        Professor professor = new Professor();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from professores where rp=?");
            preparedStatement.setInt(1, professorId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                professor.setRp(rs.getInt("rp"));
                professor.setNome(rs.getString("nome"));
                professor.setRg(rs.getString("rg"));
                professor.setCpf(rs.getLong("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professor;
    }
    
    public int countRows(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from professores");
            while (rs.next()) {
                return rs.getInt(1);   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}