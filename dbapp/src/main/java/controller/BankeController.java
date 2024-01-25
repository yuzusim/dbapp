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

    @RequestMapping(uri="/insert")
    public void insert(){
        System.out.println("controller : insert");
//        BankDAO dao = new BankDAO(); --> 할때마다 번거롭게 new 하지 않음 메인에 넣음
        dao.insert("1234",1000);
    }

    @RequestMapping(uri="/delete")
    public void delete(){
        System.out.println("controller : delete");
        dao.deleteByNumber(1);
    }

    @RequestMapping(uri="/update")
    public void update(){
        System.out.println("controller : update");
        dao.updateByNumber(1000,1);
    }

    @RequestMapping(uri="/selectOne")
    public void selectOne(){
        System.out.println("controller : selectOne");
        dao.selectByNumber(1);
    }

    @RequestMapping(uri="/selectAll")
    public void selectAll(){
        System.out.println("controller : selectAll");
        dao.selectAll();
    }


}
