
package CRUD.controller;

import CRUD.Matricula;
import CRUD.model.MatriculaDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MatriculaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/matricula.jsp";
    private static String LIST_USER = "/listarMatricula.jsp";
    private static String MAIN = "/redirect.jsp";
    private MatriculaDao dao;

    public MatriculaController() {
        super();
        dao = new MatriculaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("userId"));
            dao.delete(id);
            forward = LIST_USER;
            request.setAttribute("matriculas", dao.getAll());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("userId"));
            Matricula user = dao.getById(id);
            request.setAttribute("matricula", user);
        } else if (action.equalsIgnoreCase("listarMatricula")){
            forward = LIST_USER;
            request.setAttribute("matriculas", dao.getAll());
        } else {
            forward = MAIN;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Matricula matricula = new Matricula();
 
        matricula.setCurso(Integer.parseInt(request.getParameter("curso")));
        matricula.setTurma(Integer.parseInt(request.getParameter("turma")));
        matricula.setProfessor(Integer.parseInt(request.getParameter("professor")));
        matricula.setAluno(Integer.parseInt(request.getParameter("aluno")));

        String cod = request.getParameter("cod");
        if(cod == null || cod.isEmpty())
        {
            dao.add(matricula);
        }
        else
        {
            matricula.setCod(Integer.parseInt(cod));
            dao.update(matricula);
        }
        RequestDispatcher view = request.getRequestDispatcher(MAIN);
        view.forward(request, response);
    }
}
