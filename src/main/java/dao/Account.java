package dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * DB에 Select 한 데이터를 담기 위한 오브젝트
 */
@ToString
@AllArgsConstructor // 클래스명을 하나하나 담기 번거롭기 때문에 if (isRow)를 전부 담는 항아리라고 보면 됨 , 1번이 삭제 되어도 2번부터 들어감
@Getter
public class Account {
    private int number;
    private String password;
    private int balance;

    // java.sql의 Timestamp
    // 카멜 표기법 사용하기
    private Timestamp createdAT;
}





