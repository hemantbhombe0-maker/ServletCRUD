package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to database "information"
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/information", "root", "Hem@nt123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // 2️⃣ Insert new employee into database
    public static int insertData(Employee e) {
        int status = 0;
        String sql = "INSERT INTO employeeinformation(name, username, password, email, cono, date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setString(2, e.getUsername());
            ps.setString(3, e.getPassword());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getcono());  // ✅ matches Employee class
            ps.setString(6, e.getdate());  // ✅ matches Employee class

            status = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // 3️⃣ Validate login credentials
    public static boolean validate(String username, String password) {
        boolean status = false;
        String sql = "SELECT * FROM employeeinformation WHERE username=? AND password=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            status = rs.next(); // returns true if a record exists
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
        
        public static List<Employee> viewData()
    	{
    		List<Employee> li = new ArrayList<Employee>();
    		try 
    		{
    			Connection con = EmployeeDAO.getConnection();
    			PreparedStatement ps = con.prepareStatement("select * from employeeinformation");
    			
    			ResultSet rs = ps.executeQuery();

    			
    			while(rs.next())
    			{
    				Employee e1 = new Employee();
    				e1.setId(rs.getInt(1));
    				e1.setName(rs.getString(2));
    				e1.setUsername(rs.getString(3));
    				e1.setPassword(rs.getString(4));
    				e1.setEmail(rs.getString(5));
    				e1.setContactno(rs.getString(6));
    				e1.setBirthdate(rs.getString(7));
    				li.add(e1);
    			}
    		} 
    		catch (Exception e) {
    			
    		}
    		return li;
    	}
    }

