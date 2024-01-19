package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getInstance(){
        //return null;

        String username = "root";
        String password ="1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";
        // 마리아디비 연결 프로토콜명을 찾아야 한다.
        // DBMS 테이블까지 접근 가능하다.

        // 프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("db connect success");
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e); // JVM한테 던짐
        }

    }
}
