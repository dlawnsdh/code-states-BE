package nationOfchicken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopList {
    private static Map<String, List<Menu>> shopList = new HashMap<>();

    public static Map<String, List<Menu>> getShopList() {
        return shopList;
    }
}
