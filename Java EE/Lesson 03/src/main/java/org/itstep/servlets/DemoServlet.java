package org.itstep.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] languages = req.getParameterValues("languages");
        String referer = req.getHeader("referer");
        resp.sendRedirect(referer);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>Demo servlet</h1>");
        writer.print("<form method='post'>");
        writer.print("<select name='languages' multiple>");
        writer.print("<option value='C#'>C#</option>");
        writer.print("<option value='C++'>C++</option>");
        writer.print("<option value='Java'>Java</option>");
        writer.print("</select>");
        writer.print("<button>Send</button>");
        writer.print("</form>");
        writer.close();
    }
}
