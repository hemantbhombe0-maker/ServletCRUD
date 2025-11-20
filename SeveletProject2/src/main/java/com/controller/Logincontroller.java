package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String user = request.getParameter("user");
        String password = request.getParameter("password");

        // 🔹 Hardcoded validation (replace with DB later)
        if(user.equals("admin") && password.equals("1234")) {

            pw.println("<html><body>");
            pw.println("<div style='padding:20px; text-align:center; font-family:Arial;'>");
            pw.println("<h2 style='color:green;'>Login Successful ✔</h2>");
            pw.println("</div>");

            request.getRequestDispatcher("Dashboard.html").include(request, response);
            pw.println("</body></html>");

        } else {

            pw.println("<html><body>");
            pw.println("<div style='padding:20px; text-align:center; font-family:Arial;'>");
            pw.println("<h2 style='color:red;'>❌ Invalid Credentials</h2>");
            pw.println("<p>Please try again...</p>");
            pw.println("</div>");

            request.getRequestDispatcher("login.html").include(request, response);
            pw.println("</body></html>");
        }
	}
}
