
package CRUD.controller;

import CRUD.Curso;
import CRUD.model.CursoDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CursoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/curso.jsp";
    private static String LIST_USER = "/listarCurso.jsp";
    private static String MAIN = "/redirect.jsp";
    private CursoDao dao;

    public CursoController() {
        super();
        dao = new CursoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("userId"));
            dao.delete(id);
            forward = LIST_USER;
            request.setAttribute("cursos", dao.getAll());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("userId"));
            Curso user = dao.getById(id);
            request.setAttribute("curso", user);
        } else if (action.equalsIgnoreCase("listarCurso")){
            forward = LIST_USER;
            request.setAttribute("cursos", dao.getAll());
        } else {
            forward = MAIN;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Curso curso = new Curso();
        curso.setNome(request.getParameter("nome"));
        curso.setArea(request.getParameter("area"));
        String cod = request.getParameter("cod");
        if(cod == null || cod.isEmpty())
        {
            dao.add(curso);
        }
        else
        {
            curso.setCod(Integer.parseInt(cod));
            dao.update(curso);
        }
        RequestDispatcher view = request.getRequestDispatcher(MAIN);
        view.forward(request, response);
    }
}
