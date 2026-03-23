package btvn.bt5.dao;

import btvn.bt5.model.Patient;
import btvn.btth.config.DBConnection;
import java.sql.*;
import java.util.*;

public class PatientDAO {

    // 1. Danh sách bệnh nhân
    public List<Patient> getAll() throws Exception {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM patients";

        try (Connection conn = DBConnection.openConnection();
             PreparedStatement pre = conn.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                list.add(new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getInt("days")
                ));
            }
        }
        return list;
    }

    // 2. Thêm bệnh nhân
    public void insert(Patient p) throws Exception {
        String sql = "INSERT INTO patients(name, age, department, days) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.openConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            pre.setString(1, p.getName()); // xử lý được L'Oréal
            pre.setInt(2, p.getAge());
            pre.setString(3, p.getDepartment());
            pre.setInt(4, p.getDays());

            pre.executeUpdate();
        }
    }

    // 3. Update bệnh nhân
    public void update(Patient p) throws Exception {
        String sql = "UPDATE patients SET name=?, age=?, department=?, days=? WHERE id=?";

        try (Connection conn = DBConnection.openConnection();
             PreparedStatement pre = conn.prepareStatement(sql)) {

            pre.setString(1, p.getName());
            pre.setInt(2, p.getAge());
            pre.setString(3, p.getDepartment());
            pre.setInt(4, p.getDays());
            pre.setInt(5, p.getId());

            pre.executeUpdate();
        }
    }

    // 4. Tính viện phí (Stored Procedure)
    public double calculateFee(int id) throws Exception {
        double fee = 0;

        try (Connection conn = DBConnection.openConnection();
             CallableStatement cs = conn.prepareCall("{call CALCULATE_DISCHARGE_FEE(?, ?)}")) {

            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.DECIMAL);

            cs.execute();

            fee = cs.getDouble(2);
        }
        return fee;
    }
}