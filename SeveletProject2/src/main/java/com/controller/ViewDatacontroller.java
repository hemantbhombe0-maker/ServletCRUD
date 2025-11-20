package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.EmployeeDAO;
import com.model.Employee;

@WebServlet("/ViewDatacontroller")
public class ViewDatacontroller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        List<Employee> li = EmployeeDAO.viewData();

        pw.print("<html><head><title>Employee Data</title>");

        // CSS Styling
        pw.print("<style>");
        pw.print("body { font-family: Arial, sans-serif; background:#f4f6f9; margin:0; padding:20px; }");
        pw.print("table { width: 90%; margin: auto; border-collapse: collapse; background:white; "
        		+ "box-shadow: 0 4px 10px rgba(0,0,0,0.1); }");
        pw.print("th, td { padding: 12px; text-align: center; border-bottom: 1px solid #ddd; }");
        pw.print("th { background-color: #0078ff; color: white; font-size: 16px; }");
        pw.print("tr:nth-child(even) { background-color: #f2f2f2; }");
        pw.print(".btn-edit { background:#28a745; padding:6px 12px; color:white; border-radius:5px; "
        		+ "text-decoration:none; }");
        pw.print(".btn-delete { background:#e63946; padding:6px 12px; color:white; border-radius:5px; "
        		+ "text-decoration:none; }");
        pw.print(".btn-edit:hover { background:#218838; }");
        pw.print(".btn-delete:hover { background:#c53030; }");
        pw.print("h1 { text-align:center; margin-bottom:20px; }");
        pw.print("</style>");

        pw.print("</head><body>");

        // Title
        pw.print("<h1>Employee List</h1>");

        // Table Start
        pw.print("<table>");
        pw.print("<tr>");
        pw.print("<th>ID</th>");
        pw.print("<th>Name</th>");
        pw.print("<th>Username</th>");
        pw.print("<th>Password</th>");
        pw.print("<th>Email</th>");
        pw.print("<th>Contact</th>");
        pw.print("<th>Birth Date</th>");
        pw.print("<th>Edit</th>");
        pw.print("<th>Delete</th>");
        pw.print("</tr>");

        // Loop Through Data
        for (Employee e : li) {
            pw.print("<tr>");
            pw.print("<td>" + e.getId() + "</td>");
            pw.print("<td>" + e.getName() + "</td>");
            pw.print("<td>" + e.getUsername() + "</td>");
            pw.print("<td>" + e.getPassword() + "</td>");
            pw.print("<td>" + e.getEmail() + "</td>");
            pw.print("<td>" + e.getcono() + "</td>");
            pw.print("<td>" + e.getdate() + "</td>");
            pw.print("<td><a class='btn-edit' href='Editcontroller?id=" + e.getId() + "'>Edit</a></td>");
            pw.print("<td><a class='btn-delete' href='Deletecontroller?id=" + e.getId() + "'>Delete</a></td>");
            pw.print("</tr>");
        }

        pw.print("</table>");
        pw.print("</body></html>");
    }

    }
