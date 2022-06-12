package com.bridgelabz.db.automation.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {

    public static Connection con;
    @BeforeTest
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        String dbUrl = "jdbc:mysql://localhost:3307/student";
        String username = "root";
        String password = "pass@123";

        Connection con = DriverManager.getConnection(dbUrl,username,password);
        Class.forName("com.mysql.cj.jdbc.Driver");
        //System.out.println("Connection passed !!");

        return con;
    }
    @AfterTest
    public void tearDown() throws SQLException {
        con.close();
    }
}
