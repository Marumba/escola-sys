
package CRUD.model;

import CRUD.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao {

    private Connection connection;

    public AlunoDao() {
        connection = Conexao.Conectar();
    }

    public void add(Aluno aluno) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into alunos(rg,nome,cpf) values (?, ?, ?)");
            preparedStatement.setString(1, aluno.getRg());
            preparedStatement.setString(2, aluno.getNome());           
            preparedStatement.setLong(3, aluno.getCpf());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int alunoRa) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from alunos where ra=?");
            preparedStatement.setInt(1, alunoRa);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Aluno aluno) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update alunos set nome=?, rg=?, cpf=?" +
                            "where ra=?");
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getRg());
            preparedStatement.setLong(3, aluno.getCpf());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> getAll() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from alunos");
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setRa(rs.getInt("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getLong("cpf"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }

    public Aluno getById(int alunoId) {
        Aluno aluno = new Aluno();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from alunos where ra=?");
            preparedStatement.setInt(1, alunoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                aluno.setRa(rs.getInt("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setRg(rs.getString("rg"));
                aluno.setCpf(rs.getLong("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aluno;
    }
    
    public int countRows(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from alunos");
            while (rs.next()) {
                return rs.getInt(1);   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}