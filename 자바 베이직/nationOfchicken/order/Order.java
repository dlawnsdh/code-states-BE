package nationOfchicken;

public class Order implements ObjectListInterface {
    private String customerName;
    private String shopName;
    private String menuName;

    Order(String s1, String s2, String s3) {
        customerName = s1;
        shopName = s2;
        menuName = s3;
    }

    @Override
    public String getCustomerName() {return customerName; }
    public void setCustomerName(String str) {
        customerName  = str;
    }

    @Override
    public String getShopName() {return shopName; }
    public void setShopName(String str) {
        shopName  = str;
    }

    @Override
    public String getMenuName() {return menuName; }
    public void setSMenuName(String str) {
        menuName  = str;
    }
}
