package nationOfchicken;

public class Menu {
    private String menu;
    private int price;

    Menu(String str, int p) {
        menu = str;
        price = p;
    }

    public String getMenu() {return menu;}
    public void setMenu(String str) {menu  = str;}

    public int getPrice() {return price;}
    public void setPrice(int p) {price = p;}
}
