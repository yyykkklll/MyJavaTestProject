package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author ilc_yan
 */
public class code_01 {
    public static void main(String[] args) {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功....");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败....");
            e.printStackTrace();
        }

        //mysql 官方提供url连接地址
        //String url="jdbc:mysql://localhost:3306/idea_test_02";
        String url="jdbc:mysql://localhost:3306/stu?serverTimezone=GMT%2B8";
        String user="root";
        String password="0000";
        //建立链接
        try {
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("连接成功: "+conn);
        } catch (SQLException throwables) {
            System.out.println("连接失败");
            throwables.printStackTrace();
        }
    }
}
