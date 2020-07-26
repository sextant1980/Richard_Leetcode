package com.functionalInter;

import java.sql.*;

public class JDBCEx1 {
    public static void main(String[] args) throws SQLException {
//        Driver d = new oracle.jdbc.driver.OracleDriver();
        Driver d = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leetcode_0176", "chudong", "cubldon969");
        System.out.println(con);
        Statement stmt = con.createStatement();
        stmt.executeUpdate("insert into employee values(9, 68000)");
        con.close();
    }
}
