package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// gradle 이라는 라이브러리러 세팅시 사용가능
// junit 자바로 테스트 할 수 있는 도구

public class DBConnectionTest {

    // 리턴 타입을 못적는다. void 밖에 못적음
    // 매개변수를 적을 수 없다.
    // @Test 붙이면 메서드 별로 실행가능
    @Test
    public void getInstance_test(){
        String username = "root";
        String password ="1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";
        // 마리아디비 연결 프로토콜명을 찾아야 한다.
        // DBMS 테이블까지 접근 가능하다.

        // 프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e); // JVM한테 던짐
        }

        // 유저 네임 부터 틀려봄 -> 디버깅 해봄
        //

    }
}
