package servlets;

import org.springframework.ui.Model;
import service.Beans;
import vocabulary.ChangeOps;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class JavaServlet extends HttpServlet {
    private String name;
    Beans beans = new Beans();
    ChangeOps changeOps = (ChangeOps) Beans.context.getBean("ChangeOps");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Vocabulares.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("req");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Vocabulares.jsp");
        req.setAttribute("req", name);
        TranslateToJsp.doPost(req,resp,"hello");//вывод инфы сюда
        requestDispatcher.forward(req, resp);
    }

}
