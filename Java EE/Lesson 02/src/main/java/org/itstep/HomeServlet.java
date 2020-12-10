package org.itstep;

import org.itstep.helpers.QueryParser;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    final String VIEWS = "/WEB-INF/views/";
    //-= Жизненный цикл сервлета =-
    //1
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log("Init HomeServlet");
    }
    //2
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        log("Service in HomeServlet");
    }
    //3
    @Override
    public void destroy() {
        super.destroy();
        log("Destroy HomeServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String login = req.getParameter("login");
        String pswd = req.getParameter("password");

        resp.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //GET параметры
        /*String name = request.getParameter("name");
        String email = request.getParameter("email");
        String query = request.getQueryString();
        var queryParams = QueryParser.parse(query);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>Hello Java EE</h1>");
        writer.print(String.format("<h3>Query params = %s</h3>", query));
        writer.print("<a href='/demo'>Go to /demo</h1>");
        writer.print("<form method='post'>");
        writer.print("<input type='text' name='login' placeholder='Enter your login'>");
        writer.print("<input type='password' name='password' placeholder='Enter your password'>");
        writer.print("<input type='submit' value='Log in'>");
        writer.print("</form>");
        writer.close();*/
        var session = request.getSession();

        var vals = session.getAttribute("values");
        if (vals != null) {
            var values = (ArrayList<String>)session.getAttribute("values");
            values.add("");
        }
        else {
            session.setAttribute("values", new ArrayList<>());
        }

        request.setAttribute("message", "Hello world");
        request.setAttribute("languages", new String[] {"C++", "Java", "C#", "Python"});
        getServletContext().getRequestDispatcher(VIEWS + "home.jsp").forward(request, response);
    }
}
