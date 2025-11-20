package com.model;

public class Employee {
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String cono;
    private String date;

    public Employee() {}

    public Employee(String name, String username, String password, String email, String cono, String date) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cono = cono;
        this.date = date;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getcono() { return cono; }
    public void setContactno(String cono) { this.cono = cono; }

    public String getdate() { return date; }
    public void setBirthdate(String date) { this.date = date; }
}
