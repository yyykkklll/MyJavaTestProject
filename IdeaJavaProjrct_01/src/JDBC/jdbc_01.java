package JDBC;

import java.sql.*;

public class jdbc_01 {
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT%2B8","root","0000");
            System.out.println(conn);
            System.out.println("数据库连接成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            stmt = conn.createStatement();
            String sql_ins = "insert into stu_info values('王',191360,'男','河南省驻马店市','共青团员')";
            int count01 = stmt.executeUpdate(sql_ins);
            System.out.println(count01 == 1 ? "插入成功":"插入失败");

            String sql_del = " delete from stu_info where s_name='王'";
            int count02 = stmt.executeUpdate(sql_del);
            System.out.println(count02 == 1 ? "删除成功":"删除失败");

            String sql_set = "select * from stu_info";
            rs = stmt.executeQuery(sql_set);
            System.out.println("查询如下:");
            while (rs.next()){
                String s_name = rs.getString(1);
                int s_id = rs.getInt(2);
                String s_sex = rs.getString(3);
                String s_home = rs.getString(4);
                String s_mmao = rs.getString(5);
                System.out.println(s_name + " " +s_id +""+ s_sex + " " + s_home + " " + s_mmao);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
