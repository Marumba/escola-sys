
package CRUD.controller;

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

public class AlunoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/aluno.jsp";
    private static String LIST_USER = "/listarAluno.jsp";
    private static String MAIN = "/redirect.jsp";
    private AlunoDao dao;

    public AlunoController() {
        super();
        dao = new AlunoDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int alunoRa = Integer.parseInt(request.getParameter("userId"));
            dao.delete(alunoRa);
            forward = LIST_USER;
            request.setAttribute("alunos", dao.getAll());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int alunoRa = Integer.parseInt(request.getParameter("userId"));
            Aluno user = dao.getById(alunoRa);
            request.setAttribute("aluno", user);
        } else if (action.equalsIgnoreCase("listarAluno")){
            forward = LIST_USER;
            request.setAttribute("alunos", dao.getAll());
        } else {
            forward = MAIN;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Aluno aluno = new Aluno();
        aluno.setNome(request.getParameter("nome"));
        aluno.setRg(request.getParameter("rg"));
        aluno.setCpf(Long.parseLong(request.getParameter("cpf").trim()));
        String ra = request.getParameter("ra");
        if(ra == null || ra.isEmpty())
        {
            dao.add(aluno);
        }
        else
        {
            aluno.setRa(Integer.parseInt(ra));
            dao.update(aluno);
        }
        RequestDispatcher view = request.getRequestDispatcher(MAIN);
        view.forward(request, response);
    }
}
