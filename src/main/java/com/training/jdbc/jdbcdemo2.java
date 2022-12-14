// Create a user table in database with username and password fields. Add at least 3 records in user table
// From java code ask user to input username and password. If they match with any one record in db
// then show a message: "Logged in Successfully" else "Incorrect credentials"


package com.training.jdbc;
import java.util.Scanner;

import java.sql.*;

public class jdbcdemo2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/infinite";
        String user = "root";
        String password = "root";

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from user");

        System.out.println("Enter your username:");
        String name=sc.next();
        System.out.println("Enter your password:");
        String pass = sc.next();

        boolean flag=false;
        while(rs.next()) {

            if (rs.getString(1).equalsIgnoreCase(name) && rs.getString(2).equalsIgnoreCase(pass)) {
                flag = true;
            }

        }
        if(flag) {
            System.out.println("Logged in Successfully");
        } else {
            System.out.println("Incorrect credentials");
        }

    }
}