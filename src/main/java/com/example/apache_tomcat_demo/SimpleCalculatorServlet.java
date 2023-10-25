package com.example.apache_tomcat_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SimpleCalculator", value = "/simple-calculator")
public class SimpleCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input1 = request.getParameter("num1");
        String input2 = request.getParameter("num2");
        String output = request.getParameter("operator");

        if (input1 == null || input2 == null || output == null) {
            response.sendRedirect("./calculator.html");
            return;
        }

        try {
            double d1 = Double.parseDouble(input1);
            double d2 = Double.parseDouble(input2);

            double result = 0;

            switch (output) {
                case "Add": result = d1 + d2; break;
                case "Subtract": result = d1 - d2; break;
                case "Multiply": result = d1 * d2; break;
                case "Divide": result = d1 / d2; break;
                default:
                    throw new Exception("Invalid Operator");
            }
            request.setAttribute("result", result);
            RequestDispatcher rd = request.getRequestDispatcher("print-result");
            rd.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("./calculator.html");
        }
    }


}
