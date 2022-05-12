package JDBC;

import java.sql.*;

/**
 * @author yyykkklll
 * @version 1.0
 * @date 2022/1/25/0025 14:40
 */
public class InitMysql {
    Connection conn = null;
    PreparedStatement prstmt = null;
    ResultSet res = null;
    public void InitMyJDBC(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Register Succeed!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?serverTimezone=GMT%2B8","root","0000");
            System.out.println("Connecting Succeed!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void isClose(){
        if(res != null) {
            try { res.close(); } catch (SQLException throwables) { throwables.printStackTrace(); }
        }
        if(prstmt != null) {
            try { prstmt.close(); } catch (SQLException throwables) { throwables.printStackTrace(); }
        }
        if(conn != null) {
            try { conn.close(); } catch (SQLException throwables) { throwables.printStackTrace(); }
        }
    }
}
