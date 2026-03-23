import java.sql.*;

public class PreparedStatementDemo {
    // ke thua statement
    // cho phep truyen tham so vao

    public static void main(String[] args) {
        // mo ket noi
     //   PrepareStatementDemo DBConnection;
        try( Connection conn=DBConnection.openConnection();
            PreparedStatement pre=conn.prepareStatement("SELECT * from student where id= ?");
             PreparedStatement ps= conn.prepareStatement("INSERT INTO student (name,gpa) VALUES(?,?)");
             PreparedStatement preUpdate = conn.prepareStatement("UPDATE student SET name = ?, gpa = ? WHERE id = ?");
        ){
            // truyen tham so neu co
//            pre.setInt(1,2);// tim theo id=2
//            // thuc thi cau lenh excuteQuery neu la select
//            ResultSet resultSet=pre.executeQuery();
//            if(resultSet.next()){
//                // lay thong tin qua get
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("name"));
//                System.out.println(resultSet.getDouble("gpa"));
//            }
            // thuc hien insert va update
            // insert
            ps.setString(1,"Nguyen Van K");
            ps.setDouble(2,8.3);
            int rows=ps.executeUpdate();
            System.out.println(rows);
            // select
            pre.setInt(1,2);// tim theo id=2
            // thuc thi cau lenh excuteQuery neu la select
            ResultSet resultSet=pre.executeQuery();
            if(resultSet.next()){
                // lay thong tin qua get
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getDouble("gpa"));
            }
            // update
            preUpdate.setString(1, "Nguyen Van Updated");
            preUpdate.setDouble(2, 9.0);
            preUpdate.setInt(3, 2);

            int updateRows = preUpdate.executeUpdate();
            System.out.println("Update: " + updateRows);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
