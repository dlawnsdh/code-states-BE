package nationOfchicken;

import java.util.List;

public class Shop extends MenuList {
    private String shopName;

    Shop() {}

    public void setShopName(String str) {
        shopName = str;

    }
    public void setMenu(Menu menu) {
        getMenuList().add(menu);
    }
    public List<Menu> getMenu() {
        return getMenuList();
    }
}

