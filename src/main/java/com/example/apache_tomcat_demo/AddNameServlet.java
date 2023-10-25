package com.example.apache_tomcat_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "add-name", value = "/add-name")
public class AddNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String friendName = request.getParameter("friend_name");
        if (friendName == null || friendName.trim().length() == 0) {
            response.sendRedirect("./add-name.html");
            return;
        }

        ServletContext context = getServletContext();
        List<String> contextNames = (List<String>) context.getAttribute("nameList");
        if (contextNames == null) {
            contextNames = new ArrayList<>();
            context.setAttribute("nameList", contextNames);
        }
        contextNames.add(friendName);


        HttpSession session = request.getSession();
        List<String> names = (List<String>) session.getAttribute("nameList");

        if (names == null) {
            names = new ArrayList<>();
            session.setAttribute("nameList", names);
        }
        names.add(friendName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("add-name.html").include(request, response);
        out.println("<h3>" + friendName + " added to your friend list.</h3>");
        out.close();

    }
}
