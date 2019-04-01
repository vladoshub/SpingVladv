package servlets;


import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import vocabulary.ChangeOps;
import vocabulary.InfoBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class JavaServlet extends HttpServlet {
    private String name; ChangeOps changeOps;



    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext ac = (ApplicationContext) config.getServletContext().getAttribute("A");
         changeOps = (ChangeOps)ac.getBean("ChangeOps");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Vocabulares.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        InfoBase infoBase = (InfoBase)getServletContext().getAttribute("infoBase");
        name = req.getParameter("req");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Vocabulares.jsp");
        req.setAttribute("req", name);
        TranslateToJsp.doPost(req,resp,"hello");//вывод инфы сюда
        requestDispatcher.forward(req, resp);




    }

}
