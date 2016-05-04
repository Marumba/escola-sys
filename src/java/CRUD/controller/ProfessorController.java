
package CRUD.controller;

import CRUD.Professor;
import CRUD.model.ProfessorDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfessorController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/professor.jsp";
    private static String LIST_USER = "/listarProfessor.jsp";
    private static String MAIN = "/redirect.jsp";
    private ProfessorDao dao;

    public ProfessorController() {
        super();
        dao = new ProfessorDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int professorRp = Integer.parseInt(request.getParameter("userId"));
            dao.delete(professorRp);
            forward = LIST_USER;
            request.setAttribute("professores", dao.getAll());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int professorRp = Integer.parseInt(request.getParameter("userId"));
            Professor user = dao.getById(professorRp);
            request.setAttribute("professor", user);
        } else if (action.equalsIgnoreCase("listarProfessor")){
            forward = LIST_USER;
            request.setAttribute("professores", dao.getAll());
        } else {
            forward = MAIN;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Professor professor = new Professor();
        professor.setNome(request.getParameter("nome"));
        professor.setRg(request.getParameter("rg"));
        professor.setCpf(Long.parseLong(request.getParameter("cpf").trim()));
        String rp = request.getParameter("rp");
        if(rp == null || rp.isEmpty())
        {
            dao.add(professor);
        }
        else
        {
            professor.setRp(Integer.parseInt(rp));
            dao.update(professor);
        }
        RequestDispatcher view = request.getRequestDispatcher(MAIN);
        view.forward(request, response);
    }
}
