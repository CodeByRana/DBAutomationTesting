package com.bridgelabz.db.automation.test;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTesting extends BaseClass {

    /*** Data Insert in database ***/
    @Test
    public void dbTest_InsertData() throws SQLException, ClassNotFoundException {
        con = this.getConnection();
        String queryInsert = "INSERT INTO student VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(queryInsert);
        ps.setInt(1,3);
        ps.setString(2,"Deepak Kumar");
        ps.setInt(3,28);
        ps.setString(4,"Bangalore");
        int rowsInserted  = ps.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
    }

    /*** Fetch Data from database ***/
    @Test
    public void dbTest_GetUserData() throws SQLException,ClassNotFoundException {
        con = this.getConnection();
        String query = "SELECT *  FROM student;";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getNString(2);
            int Age = rs.getInt(3);
            String Address = rs.getString(4);
            System.out.println(id+" "+name+" "+Age+" "+Address);
        }
    }

    /*** Update Data in database ***/
    @Test
    public void dbTest_UpdateUserData() throws SQLException,ClassNotFoundException {
        con = this.getConnection();
        String queryUpdate = "UPDATE student SET NAME=? AND AGE=? WHERE ID=?";
        PreparedStatement ps = con.prepareStatement(queryUpdate);
        ps.setInt(1,3);
        ps.setString(2,"Mukesh");
        ps.setInt(3,26);
        //ps.setString(4,"Delhi");
        int rowsUpdate = ps.executeUpdate();
        if (rowsUpdate > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }

    /*** Deleted Data from database ***/
    @Test
    public void dbTest_DeleteUserData() throws SQLException,ClassNotFoundException {
        con = this.getConnection();
        String queryDelete = "DELETE FROM student WHERE ID=?";
        PreparedStatement ps = con.prepareStatement(queryDelete);
        ps.setInt(1,1);
        int rowsDeleted = ps.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
    }

}
