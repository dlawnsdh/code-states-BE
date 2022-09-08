package nationOfchicken;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private static List<Order> orderList = new ArrayList<>();

    OrderList () {}
    OrderList(Order order) {
        orderList.add(order);
    }

    public static List<Order> getOrderList() {
        return orderList;
    }
}
