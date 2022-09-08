package convenience_store;

public class Product {
    private String item;
    private int amount;

    public Product(String item) {
        this.item = item;
        amount = 0;
    }
    public void addAmount(int num) {
        amount += num;
    }
    public void subAmount(int num) {
        amount -= num;
    }
    public int getAmount() {
        return amount;
    }
    public String getItem() {
        return item;
    }
}
