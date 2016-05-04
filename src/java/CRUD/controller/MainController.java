
package CRUD.controller;

import CRUD.Usuario;
import CRUD.model.UsuarioDao;
import CRUD.Matricula;
import CRUD.model.MatriculaDao;
import CRUD.Turma;
import CRUD.model.TurmaDao;
import CRUD.Professor;
import CRUD.model.ProfessorDao;
import CRUD.Curso;
import CRUD.model.CursoDao;
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

public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String MAIN = "/main.jsp";
    private static String BAD_LOGIN = "/bad_login.jsp";
    private UsuarioDao dao;
    private AlunoDao daoAluno;
    private ProfessorDao daoProfessor;
    private CursoDao daoCurso;
    private TurmaDao daoTurma;
    private MatriculaDao daoMatricula;

    public MainController() {
        super();
        dao = new UsuarioDao();
        daoAluno = new AlunoDao();
        daoProfessor = new ProfessorDao();
        daoCurso = new CursoDao();
        daoTurma = new TurmaDao();
        daoMatricula = new MatriculaDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("curso", daoCurso.countRows());
        request.setAttribute("aluno", daoAluno.countRows());
        request.setAttribute("professor", daoProfessor.countRows());
        request.setAttribute("turma", daoTurma.countRows());
        request.setAttribute("ultimaTurma", daoTurma.altQuery("select cod from turmas order by cod DESC limit 1"));
        request.setAttribute("matricula", daoMatricula.countRows());

        request.setAttribute("alunos", daoAluno.getAll());
        request.setAttribute("professores", daoProfessor.getAll());
        request.setAttribute("cursos", daoCurso.getAll());
        request.setAttribute("turmas", daoTurma.getAll());


        RequestDispatcher view = request.getRequestDispatcher(MAIN);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("login")){
            
            String email = request.getParameter("user");
            String senha = request.getParameter("pass");
            Boolean login = dao.verifyLogin(email, senha);
            
            if (login == false){
                RequestDispatcher view = request.getRequestDispatcher(BAD_LOGIN);
                view.forward(request, response);
            }   
        }
        
        request.setAttribute("aluno", daoAluno.countRows());
        request.setAttribute("professor", daoProfessor.countRows());
        request.setAttribute("curso", daoCurso.countRows());
        request.setAttribute("turma", daoTurma.countRows());
        request.setAttribute("ultimaTurma", daoTurma.altQuery("select cod from turmas order by cod DESC limit 1"));
        request.setAttribute("matricula", daoMatricula.countRows());

        request.setAttribute("alunos", daoAluno.getAll());
        request.setAttribute("professores", daoProfessor.getAll());
        request.setAttribute("cursos", daoCurso.getAll());
        request.setAttribute("turmas", daoTurma.getAll());
        
        RequestDispatcher view = request.getRequestDispatcher(MAIN);          
        view.forward(request, response);
    }
}
