import controller.BankeController;
import lombok.AllArgsConstructor;

/**
 * 책임 : 라우팅
 * 적절한 컨트롤러를 찾아 라우팅 하는 것
 */
@AllArgsConstructor
public class Dispatcher {

    private BankeController con;

//    public Dispatcher(BankeController con) { // 의존성 주입
//        this.con = con;
//    }


    public void router(String url){
        // 라우터, 디스패쳐
        // 어떤 주소가 들어 왔을때 그걸 보고 라우팅한다.


        if (url.equals("insert")) {
            con.insert();

        } else if (url.equals("delete")) {
            con.delete();

        } else if (url.equals("update")) {
            con.update();

        } else if (url.equals("selectOne")) {
            con.selectOne();

        } else if (url.equals("selectAll")) {
            con.selectAll();

        }
    }
}
