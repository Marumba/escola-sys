
package CRUD.controller;

import CRUD.Turma;
import CRUD.model.TurmaDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TurmaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/turma.jsp";
    private static String LIST_USER = "/listarTurma.jsp";
    private static String MAIN = "/redirect.jsp";
    private TurmaDao dao;

    public TurmaController() {
        super();
        dao = new TurmaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("userId"));
            dao.delete(id);
            forward = LIST_USER;
            request.setAttribute("turmas", dao.getAll());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("userId"));
            Turma user = dao.getById(id);
            request.setAttribute("turma", user);
        } else if (action.equalsIgnoreCase("listarTurma")){
            forward = LIST_USER;
            request.setAttribute("turmas", dao.getAll());
        } else {
            forward = MAIN;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Turma turma = new Turma();
        String [] valores = request.getParameterValues("periodo");
        String periodo = "";
        for (int i = 0; i < valores.length; i++) {
            periodo += valores[i] + " ";
        }
        turma.setNome(request.getParameter("nome"));
        turma.setPeriodo(periodo.trim());
        String cod = request.getParameter("cod");
        if(cod == null || cod.isEmpty())
        {
            dao.add(turma);
        }
        else
        {
            turma.setCod(Integer.parseInt(cod));
            dao.update(turma);
        }
        RequestDispatcher view = request.getRequestDispatcher(MAIN);
        view.forward(request, response);
    }
}
