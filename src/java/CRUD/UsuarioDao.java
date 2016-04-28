
package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() {
        connection = Conexao.Conectar();
    }

    public void addUser(Usuario user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into usuarios(funcao,nome,email,senha) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, "adm");
            preparedStatement.setString(2, user.getNome());           
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getSenha());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where userid=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Usuario user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update usuarios set nome=?, email=?" +
                            "where userid=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getSenha());
            preparedStatement.setInt(4, user.getUserid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsers() {
        List<Usuario> users = new ArrayList<Usuario>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usuarios");
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setUserid(rs.getInt("userid"));
                user.setNome(rs.getString("nome"));
                user.setFuncao(rs.getString("funcao"));
                user.setEntrada(rs.getDate("entrada"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public Usuario getUserById(int userId) {
        Usuario user = new Usuario();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from usuarios where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setUserid(rs.getInt("userid"));
                user.setNome(rs.getString("nome"));
                user.setFuncao(rs.getString("funcao"));
                user.setEntrada(rs.getDate("entrada"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}