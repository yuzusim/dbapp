package controller;

import dao.BankDAO;
import lombok.AllArgsConstructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 책임 : 유효성 검사(바디데이터), 파싱(바디데이터), 적절한 DAO 찾기
 *
 */
@AllArgsConstructor
public class BankeController {

    private BankDAO dao;

    public void insert(){
        // 1. 파싱

        // 2. 유효성 검사

        // dao 찾기

        System.out.println("controller : insert");
//        BankDAO dao = new BankDAO(); --> 할때마다 번거롭게 new 하지 않음 메인에 넣음
        dao.insert("1234",1000);
    }

    public void delete(){
        System.out.println("controller : delete");
        dao.deleteByNumber(1);
    }

    public void update(){
        System.out.println("controller : update");
        dao.updateByNumber(1000,1);
    }

    public void selectOne(){
        System.out.println("controller : selectOne");
        dao.selectByNumber(1);
    }

    public void selectAll(){
        System.out.println("controller : selectAll");
        dao.selectAll();
    }


    @Retention(RetentionPolicy.RUNTIME) // 어노테이션 발동시점 -> 실행시 발동
    @Target(ElementType.METHOD) // 어노테이션 위치붙이는 곳

    public static @interface RequestMapping {
    }
}
