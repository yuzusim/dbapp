package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
* DAO -Data Access OBject
* SRP- 단일 책임 원칙
*/
public class BankDAO {

    public int deleteByNumber(int number) {

        Connection conn = DBConnection.getInstance();
        try {
            String sql="delete from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            int num = pstmt.executeUpdate();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String password, int balance){
        Connection conn = DBConnection.getInstance();
        try {
            //now()는 위치에 따라 달라진다
            String sql="insert into account_tb(password, balance, created_at) values(?, ?, now())";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, balance);
            int num = pstmt.executeUpdate();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateByNumber(int balance, int number){
        Connection conn = DBConnection.getInstance();
        try {
            //now()는 위치에 따라 달라진다
            String sql="update account_tb set balance = ? where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, balance);
            pstmt.setInt(2, number);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Account selectByNumber(int number){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            ResultSet rs = pstmt.executeQuery();
            // 뭘 만들지 모르기 때문에 ResultSet을 준다.

            //boolean isRow = rs.next(); //커서 한칸내리기 boolean타입인 이유 내려서 있으면 true 없으면 false

            // System.out.println(isRow);
            //프로젝션을 시작(컬럼을 찍어 내는 것) -> 원하는 것만 골라내는 것
//            System.out.println(rs.getInt("number"));
//            System.out.println(rs.getString("password"));
//            System.out.println(rs.getInt("balance"));
//            System.out.println(rs.getTimestamp("created_at"));

            if (rs.next()) {

                Account account = new Account( // 계좌가 최초에 생성 될때는 게터가 아닌 생성자로 초기화 하는 생성자
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> selectAll(){ // dip 시킨다.
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb order by number desc"; //전체 조회시에는 거꾸로 줘야한다. (최신순으로 준다. 내림차순)
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery(); // flash로 흘러감
            // 뭘 만들지 모르기 때문에 ResultSet을 준다.

            List<Account> accountList = new ArrayList<>();

            while (rs.next()) {
                Account account = new Account( // 계좌가 최초에 생성 될때는 게터가 아닌 생성자로 초기화 하는 생성자 // 스택에  있기 때문에 없어진다.
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
               accountList.add(account); // selectAll 메서드 안에 있다.
            }
            return accountList;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}

