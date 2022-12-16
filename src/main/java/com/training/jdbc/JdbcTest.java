package com.training.jdbc;



import java.sql.*;
        import java.util.Scanner;

public class JdbcTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc =new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/infinite";
        String user="root";
        String password = "root";
        Connection con=null;

        try {

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Enter Account details.......");
            System.out.println("Enter account number :");
            String account_no=sc.next();
            System.out.println("Enter Transaction month :");
            int trans_month=sc.nextInt();


            String sql = " {call get_credit_info(?,?,?) }";

            CallableStatement stmt =  con.prepareCall(sql);

            stmt.setString(1,account_no);
            stmt.setInt(2,trans_month);
            stmt.registerOutParameter(3, Types.DOUBLE);

            stmt.execute();
            double amount = stmt.getDouble(3);

            System.out.println("Account Number: "+account_no);
            System.out.println("Bill Month: "+trans_month);
            System.out.println("Bill Amount: "+amount);


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                con.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
