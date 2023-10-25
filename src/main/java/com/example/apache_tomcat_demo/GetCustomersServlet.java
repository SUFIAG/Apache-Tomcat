package com.example.apache_tomcat_demo;

import com.example.apache_tomcat_demo.dao.CustomerDao;
import com.example.apache_tomcat_demo.dao.DaoFactory;
import com.example.apache_tomcat_demo.entity.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getCustomers", value = "/view-customers")
public class GetCustomersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerDao dao = DaoFactory.getCustomerDao();
        List<Customer> list = dao.getAllCustomers();

        request.setAttribute("customers", list);
        request.getRequestDispatcher("/WEB-INF/views/show-customers.jsp").forward(request, response);
    }
}
