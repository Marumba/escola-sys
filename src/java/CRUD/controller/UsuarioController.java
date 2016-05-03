
package CRUD.controller;

import CRUD.Usuario;
import CRUD.model.UsuarioDao;
import CRUD.Aluno;
import CRUD.model.AlunoDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/usuario.jsp";
    private static String LOGIN = "/main.jsp";
    private static String BAD_LOGIN = "/bad_login.jsp";
    private static String LIST_USER = "/listarUsuario.jsp";
    private UsuarioDao dao;
    private AlunoDao daoAluno;

    public UsuarioController() {
        super();
        dao = new UsuarioDao();
        daoAluno = new AlunoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("usuarios", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("userId"));
            Usuario user = dao.getUserById(userId);
            request.setAttribute("usuario", user);
        } else if (action.equalsIgnoreCase("listarUsuario")){
            forward = LIST_USER;
            request.setAttribute("usuarios", dao.getAllUsers());
        } else if (action.equalsIgnoreCase("logar")){
            String email = request.getParameter("user");
            String senha = request.getParameter("pass");
            Boolean login = dao.verifyLogin(email, senha);
            if (login == true){
                forward = LOGIN;
                request.setAttribute("aluno", daoAluno.countRows());
            }else{
                forward = BAD_LOGIN;
            }
        } /*else {
            forward = INSERT_OR_EDIT;
        }*/

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario user = new Usuario();
        user.setNome(request.getParameter("nome"));
        user.setEmail(request.getParameter("email"));
        user.setSenha(request.getParameter("senha"));
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("usuarios", dao.getAllUsers());
        view.forward(request, response);
    }
}
