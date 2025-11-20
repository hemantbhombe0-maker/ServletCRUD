package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;
import com.model.Employee;

/**
 * Servlet implementation class Signupcontroller
 */
@WebServlet("/Signupcontroller")
public class Signupcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signupcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");

	        String name = request.getParameter("name");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");
	        String cono = request.getParameter("cono");
	        String date = request.getParameter("date");

	        Employee emp = new Employee(name, username, password, email, cono, date);
	        int status = EmployeeDAO.insertData(emp);

	        if (status > 0) {
	            response.getWriter().println("<script>alert('Signup successful!'); window.location='Login.html';</script>");
	        } else {
	            response.getWriter().println("<script>alert('Signup failed!'); window.location='Signup.html';</script>");
	        }
	}

}
