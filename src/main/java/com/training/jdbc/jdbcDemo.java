package com.training.jdbc;

import java.sql.*;

public class jdbcDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/infinite";
        String user = "root";
        String password = "root";


        Connection con = DriverManager.getConnection(url, user, password);

//        if(con !=null){
//            System.out.println("connection successfully!!");
//        }
//        else{
//            System.out.println("Not Found");
//        }


        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery("select * from product");

        while(rs.next()){
            System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3));
        }

    }
}
