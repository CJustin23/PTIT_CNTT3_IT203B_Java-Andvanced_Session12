package btvn.bt1;

import btvn.btth.config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
Phân tích
PreparedStatement hoạt động theo 2 bước
- biên dịch
- truyền tham số
=> thay vì cộng chuỗi thì sử dụng ? làm trình giữ chuỗi
=> không thể chèn ' OR '1'='1 để phá
 */
public class Bai1 {
    public static void main(String[] args) {
        try(
                Connection conn= DBConnection.openConnection();
                PreparedStatement pr=conn.prepareStatement(
                        "SELECT * from Doctors WHERE code= ? AND pass= ?")
                ) {
            pr.setString(1, "inputCode");
            pr.setString(2,"codePass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
