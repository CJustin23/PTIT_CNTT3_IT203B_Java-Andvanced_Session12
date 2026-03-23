package btvn.bt4;

import btvn.btth.config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
Phân tích
- với 1000 bản ghi=> lãng phí tài nguyên
- tạo statement 1000 lần, DB connect 1000 lần, gửi request 1000 lân
=> Chương trình chậm, tốn tài nguyên
 */
public class Bai4 {
    public static <TestResult> void main(String[] args) {
        List<TestResult> list = new ArrayList<>();
        try (
                Connection conn = DBConnection.openConnection();
                PreparedStatement pre = conn.prepareStatement(
                        "INSERT INTO Results(data) VALUES(?)"
                );
        ) {
            for (TestResult tr : list) {
       //         pre.setString(1, tr.getData();// getData giong vi du mau
                pre.executeUpdate(); // nhanh hơn nhiều
            }

            System.out.println("Insert thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
