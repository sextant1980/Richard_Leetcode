package com.functionalInter;

import java.sql.*;
import java.util.Scanner;

public class JDBC_Practice02 {
    public static void main(String[] args) throws SQLException {
//        Driver d = new oracle.jdbc.driver.OracleDriver();
//        Driver d = new com.mysql.jdbc.Driver();
//        DriverManager.registerDriver(d);
//        Scanner sc = new Scanner(System.in);
//        int id = sc.nextInt();
//        int salary = sc.nextInt();
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leetcode_0176", "chudong", "cubldon969");
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("select * from employee");
//        ResultSetMetaData rsm = rs.getMetaData();
//        System.out.println("column names are: " + rsm.getColumnName(1) + " and " + rsm.getColumnName(2));

            con.setAutoCommit(false);

            PreparedStatement pstmt = con.prepareStatement("insert into employee values(?, ?)");
            pstmt.setInt(1, 19);
            pstmt.setInt(2, 5800);
            pstmt.addBatch();

            pstmt.setInt(1, 20);
            pstmt.setInt(2, 6000);
            pstmt.addBatch();

            pstmt.setInt(1, 11);
            pstmt.setInt(2, 7200);
            pstmt.addBatch();

            pstmt.executeBatch();
            con.commit();
        } catch(Exception e) {
            System.out.println(e);
            con.rollback();
        } finally {
            con.close();
        }
    }
}
