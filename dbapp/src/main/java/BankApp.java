import controller.BankeController;
import controller.RequestMapping;
import dao.BankDAO;


import java.lang.reflect.Method;

public class BankApp {
    public static void main(String[] args) {
        String url = "/selectAll";

        // 누구도 만들 책임이 없는 것은 메인에서 만든다.
        BankDAO dao = new BankDAO();
        BankeController con = new BankeController(dao); // 의존성 주입

        Dispatcher dis = new Dispatcher(con); // Controller에 의존, 생서자로 만들어 준다.
        dis.router(url);

        Method[] methods = con.getClass().getDeclaredMethods(); // 그 안에 메서드 다담아
        System.out.println(methods.length);

        for (Method method : methods) {
            // System.out.println(method.getName());
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class); // 다운 캐스팅 안해도 들어감

            if (rm == null) continue;
            if (rm.uri().equals(url)) {
                System.out.println(url);
                try {
                    method.invoke(con); // con.login();때린거랑 같음, 메서드를 리플렉션으로 호출할 수 있다.
                    // 여러개 중 어떤 것을 호출할지 모르고 힙이 여러개 있을 수 있기 때문에 con 필요
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }


    }
}


