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
        // given = 파라미터 매개변수 직접 적음

        // when = 본 코드 실행 -> 본코드의 메서드를 바로 실행해봄
        Connection conn = DBConnection.getInstance();

        //then = 검증



    }
}
