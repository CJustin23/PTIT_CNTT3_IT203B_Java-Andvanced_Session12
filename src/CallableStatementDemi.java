import java.math.BigDecimal;
import java.sql.*;

public class CallableStatementDemi {
    public static void main(String[] args) {
        try(
                Connection conn=DBConnection.openConnection();
             //   CallableStatement call=conn.prepareCall("{call deleteStudentById(?)}");
                CallableStatement call=conn.prepareCall("{call countStudentMoreThanGPA(?,?)}");
                CallableStatement call1=conn.prepareCall("{call getStudentsWithCount(?)}")
                ){
            // truyen tham so
           // call.setInt(1,1);// xo id 1
            call.setBigDecimal(1, BigDecimal.valueOf(7.5));
            // dang ky tham so out neu co
            call.registerOutParameter(2, Types.INTEGER);
            // thuc thi
            call.execute();// thuc thi bthg
            // thay tham so out va su dung nhu bien thong thuong
            int countOut=call.getInt(2);// lay ra gtri tai vi tri so 2
            System.out.println(countOut);

//            int count=call.executeUpdate();
//            System.out.println("Da xoa "+ count+" ban ghi");

            // lay danh sach sinh vien kem so luong sinh vien cua lop
            // dang ky tham sao out
            call1.registerOutParameter(1,Types.INTEGER);
            boolean hasResult=call1.execute();
            // lay danh sach
            while (hasResult){
                ResultSet rs=call1.getResultSet();
                while (rs.next()){
                    System.out.println("ID "+rs.getInt("id"));
                    System.out.println("NAME "+rs.getString("name"));
                    System.out.println("GPA "+ rs.getDouble("gpa"));
                    System.out.println("_________________________________________");
                }
                hasResult = call1.getMoreResults();
            }
            // lay tong so
            int total=call1.getInt(1);
            System.out.println("Tong sinh vien "+total);
            // thuc thi
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
