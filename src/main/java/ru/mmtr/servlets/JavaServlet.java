package ru.mmtr.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.mmtr.vocabulary.ChangeOps;
import ru.mmtr.vocabulary.Library;
import ru.mmtr.vocabulary.ServiceWorker;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


//@Component("JavaSerlet")
public class JavaServlet extends HttpServlet {
    private String name;
    ChangeOps changeOps;

      private Library library;
      private ServiceWorker serviceWorker;




    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        changeOps = (ChangeOps) ac.getBean("ChangeOps");
         library = (Library) ac.getBean("Library");
         serviceWorker = (ServiceWorker) ac.getBean("ServiceWorker");
    }
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
        requestDispatcher.forward(req, resp);




    }

}
