package dao;

import org.junit.jupiter.api.Test;

import java.util.List;

public class BankDAOTest {

    @Test
    public void selectAll_test(){

        BankDAO dao = new BankDAO();
        List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());
        //System.out.println(accountList);
    }


    @Test
    public void selectByNumber_test(){
        int number = 4;

        BankDAO dao = new BankDAO();
        Account account = dao.selectByNumber(number);
        // Account ResultSet 으로 받으면 또 파싱해야하기 때문 account 담는게 편함
        if(account == null){
            System.out.println(number + "로 조회 된 값이 없습니다.");
        } else{
            System.out.println(account);

//            System.out.println(account.getNumber());
//            System.out.println(account.getPassword());
//            System.out.println(account.getBalance());
//            System.out.println(account.getCreatedAT());
        }
    }

    @Test
    public void deleteBtNumber_test(){
        // given
        int number = 1;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNumber(number);

        // then
        if(result == 1){
            System.out.println("삭제 성공");
        } else if (result == 0) {
            System.out.println(number + "번호를 찾을 수 없습니다.");
        }else {
            System.out.println("삭제 실패");
        }

    }

    @Test
    public void insert_test(){
        int balance = 1000;
        String password = "1234";

        BankDAO dao = new BankDAO();
        int result = dao.insert(password,balance);

        if (result == 1) {
            System.out.println("삽입 성공");
        }else if(result == 0){
            System.out.println("삽입할 수 없음");
        }else {
            System.out.println("삽입 실패");
        }
    }

    @Test
    public void updateByNumber_test(){
        int balance = 2000;
        int number = 2;

        BankDAO dao = new BankDAO();
        int result = dao.updateByNumber(balance, number);

        if (result == 1) {
            System.out.println("업데이트 성공");
        }else if(result == 0){
            System.out.println("업데이트할 수 없음");
        }else {
            System.out.println("업데이트 실패");
        }

    }







}
