package nationOfchicken;

import java.io.BufferedReader;
import java.io.IOException;

public class Function implements FunctionInterface {

    @Override
    public void showCommand() {
        System.out.println();
        System.out.println("[치킨의 민족 프로그램 V1] ");
        System.out.println("-".repeat(30));
        System.out.println("1) [사장님용] 음식점 등록하기");
        System.out.println("2) [사장님용] 음식메뉴 추가하기");
        System.out.println("3) [고객님과 사장님용] 음식점 별점 조회하기");
        System.out.println("4) [고객님용] 음식 주문하기");
        System.out.println("5) [고객님용] 별점 등록하기");
        System.out.println("6) 프로그램 종료하기");
        System.out.println("-".repeat(30));
    }

    @Override
    public int selectMenu(BufferedReader bf) throws IOException {
        System.out.print("[시스템] 무엇을 도와드릴까요?\n>>> ");
        return Integer.parseInt(bf.readLine());
    }

    @Override
    public void register(BufferedReader bf, Shop shop) throws IOException {
        System.out.print("[안내] 반갑습니다. 가맹주님!\n[안내] 음식점 상호는 무엇인가요?\n>>> ");
        String shopName = bf.readLine();

        System.out.print("[안내] 대표 메뉴 이름은 무엇인가요?\n>>> ");
        String menuName = bf.readLine();

        System.out.print("[안내] 해당 메뉴 가격은 얼마인가요?\n>>> ");
        int menuPrice = Integer.parseInt(bf.readLine());

        shop.setShopName(shopName);
        shop.setMenu(new Menu(menuName, menuPrice));
        ShopList.getShopList().put(shopName, shop.getMenuList());
        System.out.printf("[안내]%s에 음식(%s, %d) 추가되었습니다.\n", shopName, menuName, menuPrice);
        System.out.println("[시스템] 가게 등록이 정상 처리되었습니다.");

    }

    @Override
    public void addFood(BufferedReader bf) throws IOException {
        System.out.print("[안내] 반갑습니다. 가맹주님!\n[안내] 음식점 상호는 무엇인가요?\n>>> ");
        String shopName = bf.readLine();

        System.out.print("[안내] 추가할 메뉴 이름은 무엇인가요?\n>>> ");
        String menuName = bf.readLine();

        System.out.print("[안내] 해당 메뉴 가격은 얼마인가요?\n>>> ");
        int menuPrice = Integer.parseInt(bf.readLine());

        ShopList.getShopList().get(shopName).add(new Menu(menuName, menuPrice));
        System.out.printf("[안내]%s에 음식(%s, %d) 추가되었습니다.\n" +
                "[시스템] 메뉴 등록이 정상 처리되었습니다.\n", shopName, menuName, menuPrice);
    }

    @Override
    public void order(BufferedReader bf, OrderList orderList) throws IOException {
        System.out.print("[안내] 고객님! 메뉴 주문을 진행하겠습니다!\n[안내] 주문자 이름을 알려주세요!\n>>> ");
        String customer = bf.readLine();

        System.out.print("[안내] 주문할 음식점 상호는 무엇인가요?\n>>> ");
        String shopName = bf.readLine();

        System.out.print("[안내] 주문할 메뉴 이름을 알려주세요!\n>>> ");
        String menuName = bf.readLine();

        Order order = new Order(customer, shopName, menuName);
        orderList.getOrderList().add(order);
        System.out.printf("[안내] %s님!\n[안내] %s 매장에 %s 주문이 완료되었습니다.\n", customer, shopName, menuName);
    }

    @Override
    public void registerStar(BufferedReader bf, FeedbackList feedbackList) throws IOException {
        System.out.print("[안내] 고객님! 별점 등록을 진행합니다.\n[안내] 주문자 이름은 무엇인가요?\n>>> ");
        String customer = bf.readLine();

        System.out.print("[안내] 음식점 상호는 무엇인가요?\n>>> ");
        String shopName = bf.readLine();

        System.out.print("[안내] 주문하신 메뉴 이름을 알려주세요!\n>>> ");
        String menuName = bf.readLine();

        System.out.println("[안내] 음식맛은 어떠셨나요? (1점 ~ 5점)");
        int stars = Integer.parseInt(bf.readLine());
        System.out.println("리뷰 등록이 완료되었습니다.");

        Feedback feedback = new Feedback(customer, shopName, menuName, stars);
        feedbackList.getFeedbackList().add(feedback);
        System.out.println("[안내] 리뷰 등록이 완료되었습니다.");
    }

    @Override
    public void viewStars(BufferedReader bf, Feedback feedback) throws IOException {
        System.out.print("[안내] 고객님이 등록한 별점을 조회합니다.\n[안내] 주문자 이름은 무엇인가요?\n>>> ");
        String customer = bf.readLine();

        for (int i = 0; i < FeedbackList.getFeedbackList().size(); i++) {
            feedback = FeedbackList.getFeedbackList().get(i);
            if (feedback.getCustomerName().compareTo(customer) == 0) {
                System.out.println(customer + " [고객님]\n" + "-".repeat(30));
                String str = "★".repeat(feedback.getStars());
                System.out.printf("주문 매장 : %s\n주문 메뉴 : %s\n별점 : %s\n",
                        feedback.getShopName(), feedback.getMenuName(), str);
            }
        }
    }
}
