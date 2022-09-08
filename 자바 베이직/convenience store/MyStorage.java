package convenience_store;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyStorage {
    static List<Product> itemList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("-".repeat(30));
        System.out.println("[System] 점장님 어서오세요.\n[System] 해당 프로그램의 기능입니다.");

        Outer : while (true) {
            Function.showMenu();
            int menu = Function.selectMenu(bf, itemList);
            switch (menu) {
                case 1: Function.register(bf, itemList); break;
                case 2: Function.delete(bf, itemList); break;
                case 3: Function.addAmount(bf, itemList); break;
                case 4: Function.subAmount(bf, itemList); break;
                case 5: Function.stock(itemList); break;
                case 6:
                    System.out.print("[System] 프로그램을 종료합니다.\n[System] 감사합니다.");
                    break Outer;
                default: throw new Exception("1 ~ 6 사이의 숫자 입력 요망");
            }
        }
    }
}
