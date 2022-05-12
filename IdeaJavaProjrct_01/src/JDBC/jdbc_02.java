package JDBC;

import JDBC.InitMysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author yyykkklll
 * @version 1.0
 * @date 2022/1/25/0025 14:30
 */
public class jdbc_02 {
    static InitMysql myjdbc = new InitMysql();
    public static void main(String[] args) {
        myjdbc.InitMyJDBC();
        Map<String, String> userLoginInfo = InitUI();
        boolean flag=login(userLoginInfo);
        System.out.println(flag ? "login succeed!" : "login failed!");
        myjdbc.isClose();
    }

    private static Map<String,String> InitUI(){
        Scanner info = new Scanner(System.in);
        System.out.print("Please input userName:");
        String userName = info.nextLine();
        System.out.print("please inpu userPass:");
        String userPass = info.nextLine();
        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("username", userName);
        userLoginInfo.put("userpass", userPass);
        return userLoginInfo;
    }

    private static boolean login(Map<String, String> userLoginInfo) {
        String username = userLoginInfo.get("username");
        String userpass = userLoginInfo.get("userpass");
        String sql = " select * from user_info where userName = ? and userPass = ? ";
        try {
            myjdbc.prstmt = myjdbc.conn.prepareStatement(sql);
            myjdbc.prstmt.setString(1,username);
            myjdbc.prstmt.setString(2,userpass);
            myjdbc.res = myjdbc.prstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

}
