package nationOfchicken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class KDeliveryMain {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        FunctionInterface func = new Function();

        Outer : while (true) {
            func.showCommand();
            int menu = func.selectMenu(bf);

            switch (menu) {
                case 1:
                    Shop shop = new Shop();
                    func.register(bf, shop);

                    for (int i = 0; i < shop.getMenuList().size(); i++)
                        System.out.println(shop.getMenuList().get(i).getMenu() + " " + shop.getMenuList().get(i).getPrice());
                    break;

                case 2:
                    func.addFood(bf);
                    Set<String> keySet = ShopList.getShopList().keySet();

                    for (String key : keySet) {
                        System.out.print(key + " : ");
                        for (int i = 0; i < ShopList.getShopList().get(key).size(); i++)
                            System.out.print(ShopList.getShopList().get(key).get(i).getMenu()
                                    + " " + ShopList.getShopList().get(key).get(i).getPrice() + " ");
                        System.out.println();
                    }
                    break;

                case 3:
                    Feedback feedback = new Feedback();
                    func.viewStars(bf, feedback);
                    break;

                case 4:
                    OrderList orderList = new OrderList();
                    func.order(bf, orderList);

                    for (int i = 0; i < orderList.getOrderList().size(); i++)
                        System.out.println(orderList.getOrderList().get(i).getCustomerName() + " " + orderList.getOrderList().get(i).getShopName() + " " +
                                orderList.getOrderList().get(i).getMenuName());
                    break;

                case 5:
                    FeedbackList feedbackList = new FeedbackList();
                    func.registerStar(bf, feedbackList);

                    for (int i = 0; i < feedbackList.getFeedbackList().size(); i++)
                        System.out.println(feedbackList.getFeedbackList().get(i).getCustomerName() + " " + feedbackList.getFeedbackList().get(i).getShopName()
                               + " " + feedbackList.getFeedbackList().get(i).getMenuName() + " " + feedbackList.getFeedbackList().get(i).getStars());
                    break;

                case 6:  System.out.print("[안내] 이용해주셔서 감사합니다.\n[System] 프로그램을 종료합니다.\n");
                    bf.close();
                    break Outer;

                default: throw new Exception("\n1 ~ 6 사이의 숫자 입력 요망\n");
            }
        }
    }
}
