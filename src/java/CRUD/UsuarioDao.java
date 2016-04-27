
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
                    .prepareStatement("insert into usuarios(funcao,nome,email,senha,entrada) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, "adm");
            preparedStatement.setString(2, user.getName());           
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.setDate(5, new java.sql.Date(user.getEnterDate().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where id=?");
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
                    .prepareStatement("update users set nome=?, entrada=?, email=?" +
                            "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, user.getName());
            preparedStatement.setDate(2, new java.sql.Date(user.getEnterDate().getTime()));
            preparedStatement.setString(3, user.getEmail());
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
                user.setUserid(rs.getInt("id"));
                user.setName(rs.getString("nome"));
                user.setFunction(rs.getString("funcao"));
                user.setEnterDate(rs.getDate("entrada"));
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
                    prepareStatement("select * from usuarios where id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setUserid(rs.getInt("id"));
                user.setName(rs.getString("funcao"));
                user.setFunction(rs.getString("nome"));
                user.setEnterDate(rs.getDate("entrada"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}