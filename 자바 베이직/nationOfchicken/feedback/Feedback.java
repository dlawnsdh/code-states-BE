package nationOfchicken;

public class Feedback implements ObjectListInterface {
    private String customerName;
    private String shopName;
    private String menuName;
    private int stars;

    Feedback() {}
    Feedback(String s1, String s2, String s3, int n) {
        customerName = s1;
        shopName = s2;
        menuName = s3;
        stars = n;
    }
    @Override
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String str) {customerName  = str; }

    @Override
    public String getShopName() { return shopName; }
    public void setShopName(String str) {
        shopName  = str;
    }

    @Override
    public String getMenuName() { return menuName; }
    public void setSMenuName(String str) {
        menuName  = str;
    }

    public int getStars() { return stars; }
    public void setStars(int n) { stars = n; }
}
