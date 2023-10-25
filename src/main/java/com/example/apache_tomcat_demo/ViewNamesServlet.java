package com.example.apache_tomcat_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "view-names", value = "/view-names")
public class ViewNamesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        request.getRequestDispatcher("add-name.html").include(request, response);

        HttpSession session = request.getSession();
        List<String> names = (List<String>) session.getAttribute("nameList");

        if (names == null || names.size() == 0) {
            output.println("<h3>There are no names in your friend list.</h3>");
        } else {
            output.println("<h3>These are your friends: </h3>");
            output.println("<ul>");
            for (String name : names) {
                output.println("<li>" + name + "</li>");
            }
            output.println("</ul>");
        }

        ServletContext context = getServletContext();
        List<String> contextNames = (List<String>) context.getAttribute("nameList");
        if (contextNames != null) {
            output.println("<h3> Friend Names Added By All Users: </h3>");
            output.println("<ul>");
            for (String contextName : contextNames) {
                output.println("<li>" + contextName + "</li>");
            }
            output.println("</ul>");
        }
        output.close();
    }
}
