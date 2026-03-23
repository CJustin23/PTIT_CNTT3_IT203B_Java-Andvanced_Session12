import java.sql.*;

public class DBConnection {
    private static String DRIVER="com.mysql.cj.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3306/jdbc?createDatabaseIfNotExist=true";
    private static String USERNAME="root";
    private static String PASSWORD="yen030306.";

    static Connection openConnection(){
        // b1 khai bao driver
        try {
            Class.forName(DRIVER);// forName co nem ra ngoai le neu chua ket noi
            // mo ket noi
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Chua cai dat mysql driver");
        } catch (SQLException e) {
            System.err.println("Loi SQL: Ket noi that bai");
            e.printStackTrace();
        }
        return  null;
    }
  //  public static void main(String[] args) {
//        try(
//                // b1: mo ket noi
//                Connection conn=openConnection();// mo 1 connection
//                // b2: tao cau lenh Statement
//                Statement stm=conn.createStatement();//tao doi tuong dai dien cho cau lenh sql
//        ){
//            // tao bang:
//            String ddl= """
//                    create table Students(
//                        id int auto_increment primary key,
//                        name varchar(255) not null,
//                        gpa decimal(10,2) check(gpa>0)
//                    )
//                    """;
//           // String s="SELECT * from USER username = ? and pass= "+"abc or 1 =1 ";
//            // lay ra
//            String sql= """
//            SELECT name, gpa, id FROM students
//            """;
//            // b3: truyen tham so neu co
//            // b4: thuc thi cau lenh
//            boolean isResultSet=stm.execute(sql);// phg thuc cho phep thuc thi cau lenh => tra ve boolean
//            // true=> co ban ghi tra ve (resulSet) / false=> ko co ban ghi tra ve => so dong du lieu bi thay doi
//            System.out.println(isResultSet);
//            ResultSet rs=stm.getResultSet();// lay ra
//            while (rs.next()){
//                System.out.println("Name: "+rs.getString("name"));
//                System.out.println("GPA: "+rs.getString("gpa"));
//                System.out.println("ID: "+rs.getString("id"));
//                System.out.println("________________________________________");
//            }
            // b5: xu ly ket qua tra ve neu co
//
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//
//        // b6: dong ket noi
//    }
}
