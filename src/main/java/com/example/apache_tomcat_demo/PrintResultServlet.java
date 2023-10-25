package com.example.apache_tomcat_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "print-result", value = "/print-result")
public class PrintResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter output = response.getWriter();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./calculator.html");
        requestDispatcher.include(request, response);

        Object obj = request.getAttribute("result");
        if (obj != null) {
            double result = Double.parseDouble(obj.toString());
            output.println("<p>Result of " + request.getParameter("operator") + " operator is " + result);
            output.close();
        }
    }
}
