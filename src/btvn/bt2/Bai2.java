package btvn.bt2;

import btvn.btth.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
Phân tích
- java có thể format số theo local
- sql chỉ chấp nhận dấu .
=> PreparedStament có setDouble, setInt, vvv
=> khi truyền 37,5 qua setDouble sẽ định dạng lại đúng kiểu mà sql chấp nhận
 */
public class Bai2 {
    public static void main(String[] args) {
        try(
                Connection conn= DBConnection.openConnection();
                PreparedStatement pr=conn.prepareStatement(
                        "UPDATE Vitals SET temperature= ? WHERE  p_id= ?")
                ){

            pr.setDouble(1,37.5);
            pr.setInt(2,1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
