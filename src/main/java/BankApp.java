import controller.BankeController;
import dao.Account;
import dao.BankDAO;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        String url = "selectAll";


        // 누구도 만들 책임이 없는 것은 메인에서 만든다.
        BankDAO dao = new BankDAO();
        BankeController con = new BankeController(dao); // 의존성 주입

        Dispatcher dis = new Dispatcher(con); // Controller에 의존, 생서자로 만들어 준다.
        dis.router(url);


    }
}


