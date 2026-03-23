package btvn.bt3;

import btvn.btth.config.DBConnection;

import java.sql.*;

/*
Phân tích
- chưa đăng ký tham số out
 */
public class Bai3 {
    public static void main(String[] args) {
        try(
                Connection conn= DBConnection.openConnection();
                CallableStatement cal=conn.prepareCall(
                        "{call GET_SURGERY_FEE(?,?)}");
                ){
            cal.setInt(1,505);
            cal.registerOutParameter(2,Types.DECIMAL);
            cal.execute();
            double cost=cal.getDouble(2);
            System.out.println(cost);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
