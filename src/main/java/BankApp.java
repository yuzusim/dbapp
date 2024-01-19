import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankApp {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        // 이미 만들어진 버퍼를 활용
        try {
            String delete = "DELETE FROM account_tb WHERE number = ?";
            PreparedStatement pstmt = conn.prepareStatement(delete);
            pstmt.setInt(1, 1);

            int num = pstmt.executeUpdate(); // flash
            System.out.println(num);
        } catch (Exception e) { //SQLException --> Exception 바꾸고 부모로 퉁침 멀티 트라이 캐치 안해도 됨
            throw new RuntimeException(e);
        }


    }
}



